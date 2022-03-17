package com.okx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    @JsonProperty("live")
    LIVE,
    @JsonProperty("suspend")
    SUSPEND,
    @JsonProperty("preopen")
    PREOPEN
}
