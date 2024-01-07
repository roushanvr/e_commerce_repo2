package com.example.serviceproductttsevening.services;

import com.example.serviceproductttsevening.clients.fakestoreapi.FakeStoreCategoryDto;
import com.example.serviceproductttsevening.clients.fakestoreapi.FakeStoreClient;
import com.example.serviceproductttsevening.clients.fakestoreapi.FakeStoreGetProductsInCategoryDto;
import com.example.serviceproductttsevening.clients.fakestoreapi.FakeStoreProductDto;
import com.example.serviceproductttsevening.models.Category;
import com.example.serviceproductttsevening.models.Product;
import com.example.serviceproductttsevening.models.ProductForGetProductsInCategory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;
    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }
    private ProductForGetProductsInCategory convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto){
        ProductForGetProductsInCategory product=new ProductForGetProductsInCategory();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

//        Category category=new Category();
//        category.setName(productDto.getCategory());
        product.setCategory(productDto.getCategory());

        product.setImageUrl(productDto.getImage());
        return product;
    }
    @Override
//    public List<Category> getAllCategories() {
//        List<FakeStoreCategoryDto> fakeStoreCategoryDtos = fakeStoreClient.getAllCategories();
//        List<Category> answer=new ArrayList<>();
//
//        for(FakeStoreCategoryDto categoryDto:fakeStoreCategoryDtos){
//            answer.add(convertFakeStoreCategoryDtoToCategory(categoryDto));
//        }
//        return answer;
//    }
    public String[] getAllCategories() {
        List<String> fakeStoreCategories = fakeStoreClient.getAllCategories();

        String[] answer=new String[fakeStoreCategories.size()];
        for(int i=0; i<fakeStoreCategories.size(); i++){
            answer[i]=fakeStoreCategories.get(i);
        }
        return answer;
    }

    @Override
    public List<ProductForGetProductsInCategory> getProductsInCategory(Long categoryId) {
        List<FakeStoreProductDto> fakeStoreProductDto= fakeStoreClient.getProductsInCategory(categoryId);

        List<ProductForGetProductsInCategory> answer=new ArrayList<>();

        for(FakeStoreProductDto productDto:fakeStoreProductDto){
            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }
}
