package com.jrosroig.priceservice.infrastructure.out;

import com.jrosroig.priceservice.application.port.LoadPricePort;
import com.jrosroig.priceservice.domain.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Adapter implementing LoadPricePort using a Spring Data JPA repository.
 * This class is responsible for accessing the database and mapping the persistence entity to the domain model.
 */
@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements LoadPricePort {

    private final PriceRepository priceRepository;

    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime date, Long productId, Long brandId) {
        return priceRepository.findApplicablePrices(date, productId, brandId)
                .stream()
                .findFirst() // Select the highest priority price
                .map(this::mapToDomain);
    }

    /**
     * Maps a PriceEntity (persistence layer) to a Price domain object.
     *
     * @param entity the PriceEntity from the database
     * @return a Price object in the domain layer
     */
    private Price mapToDomain(PriceEntity entity) {
        return Price.builder()
                .priceList(entity.getPriceList())
                .brandId(entity.getBrandId())
                .productId(entity.getProductId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .currency(entity.getCurrency())
                .build();
    }
}
