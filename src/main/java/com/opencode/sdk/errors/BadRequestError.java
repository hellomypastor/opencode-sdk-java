package com.opencode.sdk.errors;

public class BadRequestError extends ApiError {
    public BadRequestError(String message, int statusCode) {
        super(message, statusCode);
    }
}
