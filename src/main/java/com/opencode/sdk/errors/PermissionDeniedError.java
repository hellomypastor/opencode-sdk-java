package com.opencode.sdk.errors;

public class PermissionDeniedError extends ApiError {
    public PermissionDeniedError(String message, int statusCode) {
        super(message, statusCode);
    }
}
