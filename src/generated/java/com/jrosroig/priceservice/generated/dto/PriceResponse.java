package com.jrosroig.priceservice.generated.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * PriceResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-02T12:19:03.430622275+02:00[Europe/Madrid]", comments = "Generator version: 7.13.0")
public class PriceResponse {

    private @Nullable Long productId;

    private @Nullable Long brandId;

    private @Nullable Long priceList;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private @Nullable OffsetDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private @Nullable OffsetDateTime endDate;

    private @Nullable Double price;

    private @Nullable String currency;

    public PriceResponse productId(Long productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Get productId
     *
     * @return productId
     */

    @Schema(name = "productId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("productId")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public PriceResponse brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    /**
     * Get brandId
     *
     * @return brandId
     */

    @Schema(name = "brandId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("brandId")
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public PriceResponse priceList(Long priceList) {
        this.priceList = priceList;
        return this;
    }

    /**
     * Get priceList
     *
     * @return priceList
     */

    @Schema(name = "priceList", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("priceList")
    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public PriceResponse startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     */
    @Valid
    @Schema(name = "startDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("startDate")
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public PriceResponse endDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     */
    @Valid
    @Schema(name = "endDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("endDate")
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public PriceResponse price(Double price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     */

    @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PriceResponse currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */

    @Schema(name = "currency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PriceResponse priceResponse = (PriceResponse) o;
        return Objects.equals(this.productId, priceResponse.productId) &&
                Objects.equals(this.brandId, priceResponse.brandId) &&
                Objects.equals(this.priceList, priceResponse.priceList) &&
                Objects.equals(this.startDate, priceResponse.startDate) &&
                Objects.equals(this.endDate, priceResponse.endDate) &&
                Objects.equals(this.price, priceResponse.price) &&
                Objects.equals(this.currency, priceResponse.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, priceList, startDate, endDate, price, currency);
    }

    @Override
    public String toString() {
        String sb = "class PriceResponse {\n" +
                "    productId: " + toIndentedString(productId) + "\n" +
                "    brandId: " + toIndentedString(brandId) + "\n" +
                "    priceList: " + toIndentedString(priceList) + "\n" +
                "    startDate: " + toIndentedString(startDate) + "\n" +
                "    endDate: " + toIndentedString(endDate) + "\n" +
                "    price: " + toIndentedString(price) + "\n" +
                "    currency: " + toIndentedString(currency) + "\n" +
                "}";
        return sb;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

