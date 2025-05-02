package com.jrosroig.priceservice.application.service;

import com.jrosroig.priceservice.application.port.LoadPricePort;
import com.jrosroig.priceservice.application.usecase.FindPriceUseCase;
import com.jrosroig.priceservice.domain.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Implementation of FindPriceUseCase.
 * Delegates the retrieval of the applicable price to a LoadPricePort output port.
 */
@Service
@RequiredArgsConstructor
public class FindPriceService implements FindPriceUseCase {

    private final LoadPricePort loadPricePort;

    @Override
    public Optional<Price> findPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        // Delegates to the output port to retrieve the applicable price
        return loadPricePort.findApplicablePrice(applicationDate, productId, brandId);
    }
}
