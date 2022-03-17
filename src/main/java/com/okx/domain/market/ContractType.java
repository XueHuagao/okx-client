package com.okx.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ContractType {
    @JsonProperty("linear")
    LINEAR,
    @JsonProperty("inverse")
    INVERSE
}
