package com.jrosroig.priceservice.infrastructure.in;

import com.jrosroig.priceservice.domain.Price;
import org.mapstruct.Mapper;
import com.jrosroig.priceservice.generated.dto.PriceResponse;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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
    @Mapping(target = "startDate", expression = "java(price.getStartDate() != null ? price.getStartDate().atOffset(java.time.ZoneOffset.UTC) : null)")
    @Mapping(target = "endDate", expression = "java(price.getEndDate() != null ? price.getEndDate().atOffset(java.time.ZoneOffset.UTC) : null)")
    PriceResponse toDto(Price price);

    /**
     * Maps a LocalDateTime (domain) to an OffsetDateTime (DTO).
     * Assumes UTC as the default offset since the domain model does not include timezone information.
     *
     * @param dateTime the LocalDateTime to convert
     * @return the corresponding OffsetDateTime with UTC offset, or null if input is null
     */
    default OffsetDateTime map(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.atOffset(java.time.ZoneOffset.UTC) : null;
    }
}
