package com.jrosroig.priceservice.infrastructure.in;

import com.jrosroig.priceservice.domain.Price;
import org.mapstruct.Mapper;
import com.jrosroig.priceservice.generated.dto.PriceResponse;

/**
 * MapStruct mapper to convert between Price domain model and PriceResponseDto.
 */
@Mapper(componentModel = "spring")
public class PriceMapper {

    /**
     * Maps a Price domain object to a PriceResponseDto.
     * Field names are similar, so default mapping applies.
     *
     * @param price the Price domain object
     * @return the mapped PriceResponseDto
     */
    PriceResponse toDto(Price price);
}
