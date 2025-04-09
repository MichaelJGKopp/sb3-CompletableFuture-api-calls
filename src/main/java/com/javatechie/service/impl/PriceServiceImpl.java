package com.javatechie.service.impl;

import com.javatechie.entity.Inventory;
import com.javatechie.entity.Price;
import com.javatechie.repository.PriceRepository;
import com.javatechie.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPriceByProductId(Long productId) {
        log.info("Getting price for the productId {}", productId);
        addDelay();
        return priceRepository.findByProductId(productId);
    }

    @Override
    @Async
    public CompletableFuture<Price> getPriceByProductIdAsync(long productId) {
        // Fetch price data and wrap it in a completed future
        Price price = getPriceByProductId(productId);
        return CompletableFuture.completedFuture(price);
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
