package com.okx.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An asset.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("ccy")
    private String symbol;

    /**
     * Chinese name of currency.
     */
    private String name;

    @JsonProperty("chain")
    private String network;

    private Boolean mainNet;

    @JsonProperty("canDep")
    private Boolean depositEnabled;

    @JsonProperty("canWd")
    private Boolean withdrawEnabled;

    @JsonProperty("canInternal")
    private Boolean transferEnabled;

    @JsonProperty("minFee")
    private Double minWithdrawFee;

    @JsonProperty("maxFee")
    private Double maxWithdrawFee;

    @JsonProperty("minWd")
    private Double minWithdrawAmount;

}