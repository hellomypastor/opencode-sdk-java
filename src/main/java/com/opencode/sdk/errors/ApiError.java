package com.opencode.sdk.errors;

/**
 * Represents an API error response.
 */
public class ApiError extends OpencodeError {

    private final int statusCode;

    public ApiError(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
