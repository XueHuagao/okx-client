package com.okx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Option type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OptionType {
    @JsonProperty("C")
    CALL,
    @JsonProperty("P")
    PUT,
}
