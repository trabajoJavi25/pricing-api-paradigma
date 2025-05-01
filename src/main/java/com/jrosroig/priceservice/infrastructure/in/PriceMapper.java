package com.jrosroig.priceservice.infrastructure.in;

import com.jrosroig.priceservice.domain.Price;
import org.mapstruct.Mapper;
import com.jrosroig.priceservice.generated.dto.PriceResponse;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

/**
 * MapStruct mapper to convert between Price domain model and PriceResponseDto.
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * Maps a Price domain object to a PriceResponseDto.
     * Field names are similar, so default mapping applies.
     *
     * @param price the Price domain object
     * @return the mapped PriceResponseDto
     */
    @Mapping(
            target = "price",
            expression = "java(price.getPrice() != null ? price.getPrice().doubleValue() : null)"
    )
    PriceResponse toDto(Price price);
}
