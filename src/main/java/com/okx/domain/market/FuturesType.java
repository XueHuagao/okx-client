package com.okx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Futures types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FuturesType {
    @JsonProperty("this_week")
    WEEKLY,
    @JsonProperty("next_week")
    BI_WEEKLY,
    @JsonProperty("quarter")
    QUARTERLY,
    @JsonProperty("next_quarter")
    BI_QUARTERLY,
}
