package com.javatechie.service;

import com.javatechie.entity.Price;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface PriceService {
    Price getPriceByProductId(Long productId);

    CompletableFuture<Price> getPriceByProductIdAsync(long productId);
}
