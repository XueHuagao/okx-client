package com.okx.impl;

import com.okx.OkxApiRestClient;
import com.okx.domain.Response;
import com.okx.domain.general.Asset;

import java.util.List;

import static com.okx.impl.OkxApiServiceGenerator.executeSync;

/**
 * Implementation of OKX's REST API using Retrofit with synchronous/blocking method calls.
 */
public class OkxApiRestClientImpl implements OkxApiRestClient {

    private final OkxApiService okxApiService;

    public OkxApiRestClientImpl(OkxApiService okxApiService) {
        this.okxApiService = okxApiService;
    }

    // General endpoints

    @Override
    public Response<List<Asset>> getAssets() {
        return executeSync(okxApiService.getAssets());
    }
}
