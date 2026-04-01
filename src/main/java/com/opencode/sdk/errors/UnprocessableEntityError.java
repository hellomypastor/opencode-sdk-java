package com.opencode.sdk.errors;

public class UnprocessableEntityError extends ApiError {
    public UnprocessableEntityError(String message, int statusCode) {
        super(message, statusCode);
    }
}
