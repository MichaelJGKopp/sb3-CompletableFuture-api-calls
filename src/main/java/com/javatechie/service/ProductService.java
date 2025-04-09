package com.javatechie.service;

import com.javatechie.entity.Product;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ProductService {
    Product findById(Long id);

    CompletableFuture<Product> getProductByIdAsync(long productId);
}
