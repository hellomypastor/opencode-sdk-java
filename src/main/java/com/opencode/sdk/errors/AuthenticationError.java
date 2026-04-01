package com.opencode.sdk.errors;

public class AuthenticationError extends ApiError {
    public AuthenticationError(String message, int statusCode) {
        super(message, statusCode);
    }
}
