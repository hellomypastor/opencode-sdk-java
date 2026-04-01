package com.opencode.sdk.errors;

/**
 * Base exception for all Opencode SDK errors.
 */
public class OpencodeError extends RuntimeException {

    public OpencodeError(String message) {
        super(message);
    }

    public OpencodeError(String message, Throwable cause) {
        super(message, cause);
    }
}
