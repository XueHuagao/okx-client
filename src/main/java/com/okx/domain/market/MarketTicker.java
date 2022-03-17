package com.okx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    @JsonProperty("instId")
    private String symbol;

    @JsonProperty("instType")
    private MarketType type;

    private Double last;

    @JsonProperty("lastSz")
    private Double lastSize;

    @JsonProperty("askPx")
    private Double askPrice;

    @JsonProperty("askSz")
    private Double askSize;

    @JsonProperty("bidPx")
    private Double bidPrice;

    @JsonProperty("bidSz")
    private Double bidSize;

    private Double open24h;
    private Double low24h;
    private Double high24h;

    @JsonProperty("vol24h")
    private Double volume24h;

    @JsonProperty("volCcy24h")
    private Double volumeAsset24h;

    @JsonProperty("sodUtc0")
    private Double openPriceUtc0;

    @JsonProperty("sodUtc8")
    private Double openPriceUtc8;

    @JsonProperty("ts")
    private Long time;

}
