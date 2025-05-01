package com.jrosroig.priceservice.application.port.in;

import com.jrosroig.priceservice.domain.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Input port interface for the price lookup use case.
 * Defines the contract to find the applicable price.
 */
public interface FindPriceUseCase {

    /**
     * Finds the applicable price for a given product, brand, and application date.
     *
     * @param applicationDate the date to apply the price
     * @param productId the product identifier
     * @param brandId the brand identifier
     * @return an Optional with the applicable Price, or empty if none found
     */
    Optional<Price> findPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
