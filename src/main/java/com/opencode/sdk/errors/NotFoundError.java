package com.opencode.sdk.errors;

public class NotFoundError extends ApiError {
    public NotFoundError(String message, int statusCode) {
        super(message, statusCode);
    }
}
