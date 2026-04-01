package com.opencode.sdk.core;

/**
 * Base class for all API resource classes.
 */
public abstract class ApiResource {

    protected final HttpClient client;

    protected ApiResource(HttpClient client) {
        this.client = client;
    }
}
