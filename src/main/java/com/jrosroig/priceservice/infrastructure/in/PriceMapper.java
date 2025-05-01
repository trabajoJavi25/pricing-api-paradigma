package com.jrosroig.priceservice.infrastructure.in;

import com.jrosroig.priceservice.domain.Price;
import org.mapstruct.Mapper;
import com.jrosroig.priceservice.generated.dto.PriceResponse;
import org.mapstruct.Mapping;

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
    @Mapping(target = "startDate", expression = "java(price.getStartDate() != null ? OffsetDateTime map(LocalDateTime price.getStartDate()) : null)")
    @Mapping(target = "endDate", expression = "java(price.getEndDate() != null ? OffsetDateTime map(LocalDateTime price.getEndDate()) : null)")
    PriceResponse toDto(Price price);
}
