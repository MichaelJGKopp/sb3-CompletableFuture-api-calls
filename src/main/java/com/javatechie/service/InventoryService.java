package com.javatechie.service;

import com.javatechie.entity.Inventory;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface InventoryService {
    Inventory getInventoryByProductId(Long productId);

    CompletableFuture<Inventory> getInventoryByProductIdAsync(long productId);
}
