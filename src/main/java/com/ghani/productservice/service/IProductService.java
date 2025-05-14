package com.ghani.productservice.service;

import com.ghani.productservice.model.Product;
import org.springframework.stereotype.Service;


public interface IProductService {
    Product getSingleProduct(long prodId);
}
