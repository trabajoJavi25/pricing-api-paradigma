package com.jrosroig.priceservice.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for accessing PriceEntity records from the database.
 * Uses Spring Data JPA with a custom query to find applicable prices.
 */
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Finds all price records valid for the given date, product, and brand.
     * Orders the results by priority descending so the first result is the applicable price.
     *
     * @param date      the date to check price validity
     * @param productId the product identifier
     * @param brandId   the brand identifier
     * @return a list of valid PriceEntity objects, ordered by priority descending
     */
    @Query("SELECT p FROM PRICE p " +
            "WHERE :date BETWEEN p.startDate AND p.endDate " +
            "AND p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "ORDER BY p.priority DESC")
    List<PriceEntity> findApplicablePrices(LocalDateTime date, Long productId, Long brandId);
}
