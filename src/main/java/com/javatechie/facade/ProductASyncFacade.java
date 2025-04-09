package com.javatechie.facade;

import com.javatechie.dto.ProductDetailDTO;
import com.javatechie.entity.Inventory;
import com.javatechie.entity.Price;
import com.javatechie.entity.Product;
import com.javatechie.service.InventoryService;
import com.javatechie.service.PriceService;
import com.javatechie.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class ProductASyncFacade {

    @Autowired
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private PriceService priceService;

    public ProductDetailDTO getProductDetails(long productId) {
        // Trigger async operations
        CompletableFuture<Product> productFuture = productService.getProductByIdAsync(productId);
        CompletableFuture<Price> priceFuture = priceService.getPriceByProductIdAsync(productId);
        CompletableFuture<Inventory> inventoryFuture = inventoryService.getInventoryByProductIdAsync(productId);

        // Wait for all futures to complete, already completed, not necessary
//        CompletableFuture.allOf(productFuture, priceFuture, inventoryFuture);

        // Combine results
        Product product = productFuture.join();
        Price price = priceFuture.join();
        Inventory inventory = inventoryFuture.join();

        // Build and return the DTO
        return new ProductDetailDTO(
                productId,
                product.getCategory().getName(),
                product.getName(),
                product.getDescription(),
                inventory.getAvailableQuantity(),
                price.getPrice(),
                inventory.getStatus()
        );
    }
}
