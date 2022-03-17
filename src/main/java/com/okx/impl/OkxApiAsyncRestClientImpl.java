package com.okx.impl;

import com.okx.OkxApiAsyncRestClient;
import com.okx.domain.Response;
import com.okx.domain.general.Asset;
import com.okx.domain.market.MarketInfo;
import com.okx.domain.market.MarketTicker;
import com.okx.domain.market.OrderBook;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of OKX's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class OkxApiAsyncRestClientImpl implements OkxApiAsyncRestClient {

    private final OkxApiService okxApiService;

    public OkxApiAsyncRestClientImpl(OkxApiService okxApiService) {
        this.okxApiService = okxApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Response<List<Asset>>> getAssets() {
        CompletableFuture<Response<List<Asset>>> future = new CompletableFuture<>();
        okxApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<Response<List<MarketInfo>>> getMarketInfo() {
        CompletableFuture<Response<List<MarketInfo>>> future = new CompletableFuture<>();
        okxApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<List<MarketTicker>>> getMarketTickers() {
        CompletableFuture<Response<List<MarketTicker>>> future = new CompletableFuture<>();
        okxApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<List<OrderBook>>> getOrderBook(String market, Integer limit) {
        CompletableFuture<Response<List<OrderBook>>> future = new CompletableFuture<>();
        okxApiService.getOrderBook(market, limit).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
