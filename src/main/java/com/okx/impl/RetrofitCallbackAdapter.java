package com.okx.impl;

import com.okx.OkxApiError;
import com.okx.exception.OkxApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.okx.impl.OkxApiServiceGenerator.getOkxApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                OkxApiError apiError = getOkxApiError(response);
                onFailure(call, new OkxApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new OkxApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof OkxApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new OkxApiException(t));
        }
    }
}
