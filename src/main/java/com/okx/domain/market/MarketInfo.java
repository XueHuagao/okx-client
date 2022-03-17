package com.okx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    @JsonProperty("instId")
    private String symbol;

    @JsonProperty("baseCcy")
    private String baseAsset;

    @JsonProperty("quoteCcy")
    private String quoteAsset;

    @JsonProperty("instType")
    private MarketType type;

    @JsonProperty("state")
    private MarketStatus status;

    private String category;

    @JsonProperty("lever")
    private Integer maxLeverage;

    @JsonProperty("alias")
    private FuturesType futuresType;

    @JsonProperty("ctType")
    private ContractType contractType;

    @JsonProperty("uly")
    private String underlying;

    @JsonProperty("settleCcy")
    private String settleAsset;

    @JsonProperty("ctVal")
    private Integer contractValue;

    @JsonProperty("ctMult")
    private Integer contractMultiplier;

    @JsonProperty("ctValCcy")
    private String contractValueAsset;

    @JsonProperty("lotSz")
    private Double lotSize;

    @JsonProperty("minSz")
    private Double mitOrderSize;

    @JsonProperty("tickSz")
    private Double tickSize;

    @JsonProperty("optType")
    private OptionType optionType;

    @JsonProperty("stk")
    private Double strikePrice;

    private Long listTime;
    private Long expTime;

}
