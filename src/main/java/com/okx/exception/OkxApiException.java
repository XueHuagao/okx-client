package com.okx.exception;

import com.okx.OkxApiError;

/**
 * An exception which can occur while invoking methods of the OKX API.
 */
public class OkxApiException extends RuntimeException {

    private static final long serialVersionUID = -3970901294273477935L;

    private OkxApiError error;

    public OkxApiException(OkxApiError error) {
        this.error = error;
    }

    public OkxApiException() {
        super();
    }

    public OkxApiException(String message) {
        super(message);
    }

    public OkxApiException(Throwable cause) {
        super(cause);
    }

    public OkxApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from OKX API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public OkxApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
