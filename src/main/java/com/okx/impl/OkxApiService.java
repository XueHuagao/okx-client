package com.okx.impl;

import com.okx.domain.Response;
import com.okx.domain.general.Asset;
import com.okx.domain.market.MarketInfo;
import com.okx.domain.market.MarketTicker;
import com.okx.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

import static com.okx.constant.OkxAPIConstants.AUTHORIZATION_REQUIRED_HEADER;

/**
 * OKX's REST API URL mappings.
 */
public interface OkxApiService {

    // General endpoints

    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @GET("/api/v5/asset/currencies")
    Call<Response<List<Asset>>> getAssets();

    // Market endpoints

    @GET("/api/v5/public/instruments?instType=SPOT")
    Call<Response<List<MarketInfo>>> getMarketInfo();

    @GET("/api/v5/market/tickers?instType=SPOT")
    Call<Response<List<MarketTicker>>> getMarketTickers();

    @GET("/api/v5/market/books")
    Call<Response<List<OrderBook>>> getOrderBook(@Query("instId") String market, @Query("sz") Integer limit);

}
