package com.ghani.productservice.service.impl;

import com.ghani.productservice.config.ApplicationConfig;
import com.ghani.productservice.dto.FakeStoreDTO;
import com.ghani.productservice.model.Category;
import com.ghani.productservice.model.Product;
import com.ghani.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ApplicationConfig applicationConfig;

    @Override
    public Product getSingleProduct(long prodId) {
        ResponseEntity<FakeStoreDTO> responseEntity=applicationConfig.getRestTemplate().getForEntity("https://fakestoreapi.com/products/"+prodId,FakeStoreDTO.class);
        return converterToProduct(responseEntity.getBody(),prodId);
    }

    private Product converterToProduct(FakeStoreDTO fakeStoreDTO,long prodId) {
        Product product = new Product();
        Category category = new Category();
        category.setTitle(fakeStoreDTO.getCategory());
        product.setId(prodId);
        product.setTitle(fakeStoreDTO.getTitle());
        product.setDescription(fakeStoreDTO.getDescription());
        product.setPrice(fakeStoreDTO.getPrice());
        product.setImageUrl(fakeStoreDTO.getImage());
        product.setCategory(category);
        return product;
    }
}
