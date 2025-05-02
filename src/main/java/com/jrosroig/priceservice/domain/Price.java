package com.jrosroig.priceservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Domain model representing a product price.
 * This class contains the business attributes without persistence concerns.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

    private Long priceList;
    private Long brandId;
    private Long productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private BigDecimal price;
    private String currency;
}
