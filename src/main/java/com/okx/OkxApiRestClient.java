package com.okx;

import com.okx.domain.Response;
import com.okx.domain.general.Asset;
import com.okx.domain.market.MarketInfo;

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

}