package com.opencode.sdk.errors;

public class InternalServerError extends ApiError {
    public InternalServerError(String message, int statusCode) {
        super(message, statusCode);
    }
}
