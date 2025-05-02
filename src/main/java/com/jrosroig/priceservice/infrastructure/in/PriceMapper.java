package com.jrosroig.priceservice.infrastructure.in;

import com.jrosroig.priceservice.domain.Price;
import com.jrosroig.priceservice.generated.dto.PriceResponse;
import org.mapstruct.Mapper;
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
    @Mapping(target = "startDate", expression = "java(price.getStartDate() != null ? price.getStartDate().atOffset(java.time.ZoneOffset.UTC) : null)")
    @Mapping(target = "endDate", expression = "java(price.getEndDate() != null ? price.getEndDate().atOffset(java.time.ZoneOffset.UTC) : null)")
    @Mapping(target = "productId", expression = "java(price.getProductId())")
    @Mapping(target = "brandId", expression = "java(price.getBrandId())")
    @Mapping(target = "priceList", expression = "java(price.getPriceList())")
    @Mapping(target = "currency", expression = "java(price.getCurrency())")
    PriceResponse toDto(Price price);

}
