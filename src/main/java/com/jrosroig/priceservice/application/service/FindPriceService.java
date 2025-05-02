package com.jrosroig.priceservice.application.service;

import com.jrosroig.priceservice.application.port.in.FindPriceUseCase;
import com.jrosroig.priceservice.domain.Price;
import com.jrosroig.priceservice.infrastructure.out.PriceEntity;
import com.jrosroig.priceservice.infrastructure.out.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Implementation of FindPriceUseCase.
 * Contains the business logic to retrieve the applicable price.
 */
@Service
@RequiredArgsConstructor
public class FindPriceService implements FindPriceUseCase {

    private final PriceRepository priceRepository;

    @Override
    public Optional<Price> findPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceRepository.findApplicablePrices(applicationDate, productId, brandId)
                .stream()
                .findFirst()
                .map(this::mapToDomain);
    }

    /**
     * Maps a PriceEntity to a Price domain object.
     *
     * @param entity the PriceEntity
     * @return the corresponding Price domain object
     */
    private Price mapToDomain(PriceEntity entity) {
        return Price.builder().priceList(entity.getPriceList()).brandId(entity.getBrandId())
                .productId(entity.getProductId()).startDate(entity.getStartDate()).endDate(entity.getEndDate())
                .priority(entity.getPriority()).price(entity.getPrice()).currency(entity.getCurrency()).build();
    }
}
