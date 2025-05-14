package com.ghani.productservice.service;

import com.ghani.productservice.model.Product;

import java.util.List;


public interface IProductService {
    Product getSingleProduct(long prodId);
    List<Product> getAllProducts();
}
