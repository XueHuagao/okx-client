package com.okx.impl;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.okx.OkxApiClientFactory;
import com.okx.OkxApiRestClient;
import com.okx.domain.Response;
import com.okx.domain.general.Asset;
import com.okx.domain.market.MarketInfo;
import com.okx.domain.market.MarketTicker;
import com.okx.domain.market.OrderBook;
import com.okx.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OkxApiRestClientImplTest {

    private OkxApiRestClient okxApiRestClient;

    @BeforeEach
    public void setUp() {
//        String apiKey = System.getenv("API_KEY");
//        String secret = System.getenv("SECRET");
//        String passphrase = System.getenv("PASSPHRASE");
        String apiKey = "6e33be67-f587-4740-8edb-a0f840b19d75";
        String secret = "FC546464E3B4954CDE69AE0EDE13241F";
        String passphrase = "Xnmbyy+1s";
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret, passphrase);
        this.okxApiRestClient = OkxApiClientFactory.newInstance(apiCredentials).newRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() {
        Response<List<Asset>> response = okxApiRestClient.getAssets();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() {
        Response<List<MarketInfo>> response = okxApiRestClient.getMarketInfo();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Response<List<MarketTicker>> response = okxApiRestClient.getMarketTickers();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() {
        Response<List<OrderBook>> response = okxApiRestClient.getOrderBook("BTC-USDT", 20);
        assertNotNull(response);
        assertThat(response.getData().get(0).getAsks(), is(not(empty())));
        assertThat(response.getData().get(0).getBids(), is(not(empty())));
    }
}