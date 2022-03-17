package com.okx;

import com.okx.domain.Response;
import com.okx.domain.general.Asset;
import com.okx.domain.market.MarketInfo;
import com.okx.domain.market.MarketTicker;

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

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<Response<List<MarketInfo>>> getMarketInfo();

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Response<List<MarketTicker>>> getMarketTickers();

}