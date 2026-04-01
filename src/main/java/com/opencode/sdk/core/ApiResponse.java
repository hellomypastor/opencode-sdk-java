package com.opencode.sdk.core;

import java.util.Map;

/**
 * Wraps a parsed response body along with raw HTTP metadata.
 */
public class ApiResponse<T> {

    private final T data;
    private final int statusCode;
    private final Map<String, String> headers;

    public ApiResponse(T data, int statusCode, Map<String, String> headers) {
        this.data = data;
        this.statusCode = statusCode;
        this.headers = headers;
    }

    public T getData() {
        return data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
