package com.opencode.sdk.resources;

import com.opencode.sdk.core.ApiResource;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.RequestOptions;
import com.opencode.sdk.models.config.Config;

/**
 * Access configuration info.
 */
public class ConfigResource extends ApiResource {

    public ConfigResource(HttpClient client) {
        super(client);
    }

    /**
     * Get config info.
     */
    public Config get() {
        return get(null);
    }

    public Config get(RequestOptions options) {
        return client.get("/config", Config.class, options);
    }
}
