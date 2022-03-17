package com.okx;

import com.okx.domain.Response;
import com.okx.domain.general.Asset;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * OKX API facade, supporting asynchronous/non-blocking access OKX's REST API.
 */
public interface OkxApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Response<List<Asset>>> getAssets();

}