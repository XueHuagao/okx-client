package com.okx.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response wrapper.
 *
 * @param <T> payload type
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {
    private Integer code;
    private String msg;
    private T data;
}
