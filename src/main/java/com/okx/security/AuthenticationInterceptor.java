package com.okx.security;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.okx.constant.OkxAPIConstants.*;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final ApiCredentials apiCredentials;

    public AuthenticationInterceptor(ApiCredentials apiCredentials) {
        this.apiCredentials = apiCredentials;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isApiKeyRequired = original.header(AUTHORIZATION_REQUIRED) != null;
        newRequestBuilder.removeHeader(AUTHORIZATION_REQUIRED);

        // Endpoint requires sending a valid API-KEY
        if (isApiKeyRequired) {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));

            final String timestamp = df.format(new Date());

            String payload = timestamp + original.method() + original.url().encodedPath();

            if (original.method().equals("POST")) {
                payload += bodyToString(original.body());
            }

            String signature = HmacSHA256Signer.sign(payload, apiCredentials.getSecret());

            newRequestBuilder.addHeader(API_KEY_HEADER, apiCredentials.getApiKey());
            newRequestBuilder.addHeader(API_SIGN_HEADER, signature);
            newRequestBuilder.addHeader(API_TIMESTAMP_HEADER, timestamp);
            newRequestBuilder.addHeader(API_PASSPHRASE_HEADER, apiCredentials.getPassphrase());
            newRequestBuilder.tag(String.class, apiCredentials.getApiKey());
        }

        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    private static String bodyToString(RequestBody request) {
        try (final Buffer buffer = new Buffer()) {
            if (request != null) {
                request.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}