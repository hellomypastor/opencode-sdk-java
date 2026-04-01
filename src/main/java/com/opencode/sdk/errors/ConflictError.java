package com.opencode.sdk.errors;

public class ConflictError extends ApiError {
    public ConflictError(String message, int statusCode) {
        super(message, statusCode);
    }
}
