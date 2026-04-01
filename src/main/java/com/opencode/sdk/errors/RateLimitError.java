package com.opencode.sdk.errors;

public class RateLimitError extends ApiError {
    public RateLimitError(String message, int statusCode) {
        super(message, statusCode);
    }
}
