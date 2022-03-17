package com.okx;

import com.okx.domain.Response;
import com.okx.domain.general.Asset;
import com.okx.domain.market.MarketInfo;
import com.okx.domain.market.MarketTicker;
import com.okx.domain.market.OrderBook;

import java.util.List;

/**
 * OKX API facade, supporting synchronous/blocking access OKX's REST API.
 */
public interface OkxApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Response<List<Asset>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    Response<List<MarketInfo>> getMarketInfo();

    /**
     * Get market ticker information.
     *
     * @return market tickers
     */
    Response<List<MarketTicker>> getMarketTickers();

    /**
     * Get orderbook for the market.
     *
     * @param market market symbol (e.g. BTC-USDT)
     * @param limit  depth of the order book. Max depth 400.
     * @return orderbook
     */
    Response<List<OrderBook>> getOrderBook(String market, Integer limit);

}