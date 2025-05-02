package com.jrosroig.priceservice.infrastructure.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * JPA Entity mapped to the PRICE table in the database.
 * Used for persistence operations (reading/writing to DB).
 */
@Entity(name = "PRICE")
@Data
@NoArgsConstructor
public class PriceEntity {
    @Id
    private Long priceList;
    private Long brandId;
    private Long productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private BigDecimal price;
    private String currency;
}
