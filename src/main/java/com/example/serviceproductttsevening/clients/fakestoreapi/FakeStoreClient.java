package com.example.serviceproductttsevening.clients.fakestoreapi;

import com.example.serviceproductttsevening.dtos.ProductDto;
import com.example.serviceproductttsevening.exceptions.NotFoundException;
import com.example.serviceproductttsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    //copied from postForEntity code
    private<T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object...uriVariables) throws RestClientException {
        RestTemplate restTemplate=restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod , requestCallback, responseExtractor, uriVariables);
    }
    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l=restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        return Arrays.asList(l.getBody());
    }
    public Optional<FakeStoreProductDto> getSingleProduct(Long productId) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class,
                productId);
        FakeStoreProductDto productDto=response.getBody();

        if(productDto==null){
            return Optional.empty();
        }
        return Optional.of(productDto);
    }

    public FakeStoreProductDto addNewProduct(ProductDto productDto){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity("https://fakestoreapi.com/products",
                productDto,
                FakeStoreProductDto.class);
        //(url, which product u want to add(body), response that we will get)
        return response.getBody();
    }

    public FakeStoreProductDto updateProduct(Long productId, Product product){
        //converting product to productDto
        FakeStoreProductDto productDto=new FakeStoreProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setImage(product.getImageUrl());
        productDto.setCategory(product.getCategory().getName());
        productDto.setPrice(product.getPrice());

        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                productDto,
                FakeStoreProductDto.class,
                productId
        );
        return fakeStoreProductDtoResponseEntity.getBody();
    }
    public FakeStoreProductDto replaceProduct(Long productId, Product product){
        //converting product to productDto
        FakeStoreProductDto productDto=new FakeStoreProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setImage(product.getImageUrl());
        productDto.setCategory(product.getCategory().getName());
        productDto.setPrice(product.getPrice());

        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=requestForEntity(
                HttpMethod.PUT,
                "https://fakestoreapi.com/products/{id}",
                productDto,
                FakeStoreProductDto.class,
                productId
        );
        return fakeStoreProductDtoResponseEntity.getBody();
    }
    public FakeStoreProductDto deleteProduct(Long productId, Product product){
        //converting product to productDto
        FakeStoreProductDto productDto=new FakeStoreProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setImage(product.getImageUrl());
        productDto.setCategory(product.getCategory().getName());
        productDto.setPrice(product.getPrice());

        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=requestForEntity(
                HttpMethod.DELETE,
                "https://fakestoreapi.com/products/{id}",
                productDto,
                FakeStoreProductDto.class,
                productId
        );
        return fakeStoreProductDtoResponseEntity.getBody();
    }

//    public List<FakeStoreCategoryDto> getAllCategories(){
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreCategoryDto[]> l=restTemplate.getForEntity("https://fakestoreapi.com/products/categories",
//                FakeStoreCategoryDto[].class);
//
//        return Arrays.asList(l.getBody());
//    }

    public List<String> getAllCategories(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<String[]> l=restTemplate.getForEntity("https://fakestoreapi.com/products/categories",
               String[].class);

       return Arrays.asList(l.getBody());
    }

    public List<FakeStoreProductDto> getProductsInCategory(Long categoryId){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l=restTemplate.getForEntity("https://fakestoreapi.com/products/category/jewelery",
                FakeStoreProductDto[].class);

        return Arrays.asList(l.getBody());
    }
}
