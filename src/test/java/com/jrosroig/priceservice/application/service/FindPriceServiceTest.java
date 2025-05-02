package com.jrosroig.priceservice.application.service;

import com.jrosroig.priceservice.application.port.LoadPricePort;
import com.jrosroig.priceservice.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class FindPriceServiceTest {
    private LoadPricePort loadPricePort;
    private FindPriceService findPriceService;

    @BeforeEach
    void setUp() {
        loadPricePort = mock(LoadPricePort.class);
        findPriceService = new FindPriceService(loadPricePort);
    }

    @Test
    void should_return_price_when_found() {
        // Given
        Price price = Price.builder()
                .priceList(1L)
                .brandId(1L)
                .productId(35455L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusHours(1))
                .price(BigDecimal.valueOf(35.50))
                .currency("EUR")
                .build();

        when(loadPricePort.findApplicablePrice(any(), any(), any())).thenReturn(Optional.of(price));

        // When
        Optional<Price> result = findPriceService.findPrice(LocalDateTime.now(), 35455L, 1L);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getPriceList()).isEqualTo(1L);

        verify(loadPricePort, times(1)).findApplicablePrice(any(), any(), any());
    }

    @Test
    void should_return_empty_when_not_found() {
        // Given
        when(loadPricePort.findApplicablePrice(any(), any(), any())).thenReturn(Optional.empty());

        // When
        Optional<Price> result = findPriceService.findPrice(LocalDateTime.now(), 35455L, 1L);

        // Then
        assertThat(result).isEmpty();

        verify(loadPricePort, times(1)).findApplicablePrice(any(), any(), any());
    }
}
