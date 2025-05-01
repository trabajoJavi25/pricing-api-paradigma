package com.jrosroig.priceservice.infrastructure.in;

import com.jrosroig.priceservice.application.port.in.FindPriceUseCase;
import com.jrosroig.priceservice.domain.Price;
import com.jrosroig.priceservice.generated.api.PricesApi;
import com.jrosroig.priceservice.generated.dto.PriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * REST controller implementing the PricesApi interface from OpenAPI.
 * Acts as input adapter in hexagonal architecture.
 */
@RestController
@RequiredArgsConstructor
public class PriceContoller implements PricesApi {

    private final FindPriceUseCase findPriceUseCase;
    private final PriceMapper priceMapper;

    @Override
    public ResponseEntity<PriceResponse> pricesGet(Integer productId, Integer brandId, OffsetDateTime applicationDate) {
        // Convert OffsetDateTime to LocalDateTime
        LocalDateTime localDateTime = applicationDate.toLocalDateTime();

        Optional<Price> result = findPriceUseCase.findPrice(localDateTime, productId.longValue(), brandId.longValue());


        return result
                .map(priceMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
