package com.okx.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout OKX's API.
 */
@UtilityClass
public class OkxAPIConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "okx.com";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://aws." + BASE_DOMAIN;

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "OK-ACCESS-KEY";
    public static final String API_SIGN_HEADER = "OK-ACCESS-SIGN";
    public static final String API_TIMESTAMP_HEADER = "OK-ACCESS-TIMESTAMP";
    public static final String API_PASSPHRASE_HEADER = "OK-ACCESS-PASSPHRASE";

    /**
     * Decorator to indicate that an endpoint requires authorization.
     */
    public static final String AUTHORIZATION_REQUIRED = "AUTHORIZATION";
    public static final String AUTHORIZATION_REQUIRED_HEADER = AUTHORIZATION_REQUIRED + ": #";
}