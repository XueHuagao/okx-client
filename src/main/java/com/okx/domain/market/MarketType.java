package com.okx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Market types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketType {
    SPOT,
    MARGIN,
    SWAP,
    FUTURES,
    OPTION
}
