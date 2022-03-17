package com.okx;

import com.okx.impl.OkxApiAsyncRestClientImpl;
import com.okx.impl.OkxApiRestClientImpl;
import com.okx.impl.OkxApiService;
import com.okx.impl.OkxApiServiceGenerator;
import com.okx.security.ApiCredentials;
import okhttp3.OkHttpClient;

/**
 * A factory for creating OKX API client objects.
 */
public class OkxApiClientFactory {

    private final OkxApiServiceGenerator serviceGenerator;

    private final ApiCredentials apiCredentials;

    public OkxApiClientFactory() {
        this(new OkHttpClient(), null);
    }

    public OkxApiClientFactory(ApiCredentials apiCredentials) {
        this(new OkHttpClient(), apiCredentials);
    }

    private OkxApiClientFactory(OkHttpClient client, ApiCredentials apiCredentials) {
        this.serviceGenerator = new OkxApiServiceGenerator(client);
        this.apiCredentials = apiCredentials;
    }

    /**
     * New instance without authentication.
     *
     * @return the OKX API client factory
     */
    public static OkxApiClientFactory newInstance() {
        return new OkxApiClientFactory();
    }

    /**
     * New instance with authentication.
     *
     * @return the OKX API client factory
     */
    public static OkxApiClientFactory newInstance(ApiCredentials apiCredentials) {
        return new OkxApiClientFactory(apiCredentials);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public OkxApiRestClient newRestClient() {
        return new OkxApiRestClientImpl(serviceGenerator.createService(OkxApiService.class, apiCredentials));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public OkxApiAsyncRestClient newAsyncRestClient() {
        return new OkxApiAsyncRestClientImpl(serviceGenerator.createService(OkxApiService.class, apiCredentials));
    }
}
