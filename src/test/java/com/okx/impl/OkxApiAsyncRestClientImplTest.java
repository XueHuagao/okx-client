package com.okx.impl;

import com.okx.OkxApiAsyncRestClient;
import com.okx.OkxApiClientFactory;
import com.okx.domain.Response;
import com.okx.domain.general.Asset;
import com.okx.domain.market.MarketInfo;
import com.okx.domain.market.MarketTicker;
import com.okx.domain.market.OrderBook;
import com.okx.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OkxApiAsyncRestClientImplTest {

    private OkxApiAsyncRestClient okxApiAsyncRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        String passphrase = System.getenv("PASSPHRASE");
//        String apiKey="6e33be67-f587-4740-8edb-a0f840b19d75";
//        String secret="FC546464E3B4954CDE69AE0EDE13241F";
//        String passphrase="Xnmbyy+1s";
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret, passphrase);
        this.okxApiAsyncRestClient = OkxApiClientFactory.newInstance(apiCredentials).newAsyncRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Response<List<Asset>> response = okxApiAsyncRestClient.getAssets().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() throws ExecutionException, InterruptedException {
        Response<List<MarketInfo>> response = okxApiAsyncRestClient.getMarketInfo().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        Response<List<MarketTicker>> response = okxApiAsyncRestClient.getMarketTickers().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() throws ExecutionException, InterruptedException {
        Response<List<OrderBook>> response = okxApiAsyncRestClient.getOrderBook("BTC-USDT", 20).get();
        assertNotNull(response);
        assertThat(response.getData().get(0).getAsks(), is(not(empty())));
        assertThat(response.getData().get(0).getBids(), is(not(empty())));
    }
}