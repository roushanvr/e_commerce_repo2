package com.example.serviceproductttsevening.services;

import com.example.serviceproductttsevening.clients.fakestoreapi.FakeStoreClient;
import com.example.serviceproductttsevening.clients.fakestoreapi.FakeStoreProductDto;
import com.example.serviceproductttsevening.dtos.ProductDto;
import com.example.serviceproductttsevening.exceptions.NotFoundException;
import com.example.serviceproductttsevening.models.Category;
import com.example.serviceproductttsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductServiceImpl implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;
    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }
    private Product converFakeStoreProductDtoToProduct(FakeStoreProductDto productDto){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);

        product.setImageUrl(productDto.getImage());
        return product;
    }


    @Override
    public List<Product> getAllProducts() {
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto[]> l=restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        //(at what url we have to send request, List of productDto in response)
        //List<ProductDto>.class will face TYPE ERASER issue
        //What's the datatype of list is not visible at runtime.

        List<FakeStoreProductDto> fakeStoreProductDtos=fakeStoreClient.getAllProducts();
        List<Product> answer=new ArrayList<>();

        for(FakeStoreProductDto productDto:fakeStoreProductDtos){
            answer.add(converFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }
   // It will return a product object with all the details of the fetched product
    @Override
    public Optional<Product> getSingleProduct(Long productId){
        Optional<FakeStoreProductDto> fakeStoreProductDto=fakeStoreClient.getSingleProduct(productId);

        if(fakeStoreProductDto.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(converFakeStoreProductDtoToProduct(fakeStoreProductDto.get()));

    }

    @Override
    public Product addNewProduct(ProductDto productDto) {

        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.addNewProduct(productDto);
        return converFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.updateProduct(productId,product);
        return converFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.replaceProduct(productId,product);
        return converFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
    @Override
    public Product deleteProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto=fakeStoreClient.deleteProduct(productId,product);
        return converFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
}
