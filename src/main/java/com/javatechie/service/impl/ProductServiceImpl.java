package com.javatechie.service.impl;

import com.javatechie.entity.Inventory;
import com.javatechie.entity.Price;
import com.javatechie.entity.Product;
import com.javatechie.repository.ProductRepository;
import com.javatechie.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        log.info("Service request to fetch product by id: {}", id);
        addDelay();
        return productRepository.findById(id).orElse(null);
    }

    @Async
    @Override
    public CompletableFuture<Product> getProductByIdAsync(long productId) {
        // Fetch product data and wrap it in a completed future
        Product product = findById(productId);
        return CompletableFuture.completedFuture(product);
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
