package com.opencode.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.opencode.sdk.core.ApiResource;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.RequestOptions;
import com.opencode.sdk.models.app.*;

import java.util.List;

/**
 * Access app information, modes, and providers.
 */
public class AppResource extends ApiResource {

    public AppResource(HttpClient client) {
        super(client);
    }

    /**
     * Get app info.
     */
    public App get() {
        return get(null);
    }

    public App get(RequestOptions options) {
        return client.get("/app", App.class, options);
    }

    /**
     * Initialize the app.
     */
    public boolean init() {
        return init(null);
    }

    public boolean init(RequestOptions options) {
        return client.post("/app/init", Boolean.class, options);
    }

    /**
     * Write a log entry to the server logs.
     */
    public boolean log(AppLogParams params) {
        return log(params, null);
    }

    public boolean log(AppLogParams params, RequestOptions options) {
        return client.post("/log", params, Boolean.class, options);
    }

    /**
     * List all modes.
     */
    public List<Mode> modes() {
        return modes(null);
    }

    public List<Mode> modes(RequestOptions options) {
        return client.get("/mode", new TypeReference<List<Mode>>() {}, options);
    }

    /**
     * List all providers.
     */
    public AppProvidersResponse providers() {
        return providers(null);
    }

    public AppProvidersResponse providers(RequestOptions options) {
        return client.get("/config/providers", AppProvidersResponse.class, options);
    }
}
