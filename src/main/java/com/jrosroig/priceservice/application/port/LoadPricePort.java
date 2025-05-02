package com.jrosroig.priceservice.application.port;

import com.jrosroig.priceservice.domain.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Output port interface to abstract the retrieval of a price from the persistence layer.
 * The application/service layer depends on this interface, allowing decoupling from the actual database implementation.
 */
public interface LoadPricePort {

    /**
     * Retrieves the applicable price for a given product, brand and application date.
     *
     * @param date      the application date
     * @param productId the product identifier
     * @param brandId   the brand identifier
     * @return an Optional containing the applicable Price, or empty if none found
     */
    Optional<Price> findApplicablePrice(LocalDateTime date, Long productId, Long brandId);
}
