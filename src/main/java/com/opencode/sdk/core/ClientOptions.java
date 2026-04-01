package com.opencode.sdk.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration options for the Opencode client.
 */
public class ClientOptions {

    public static final String DEFAULT_BASE_URL = "http://localhost:54321";
    public static final long DEFAULT_TIMEOUT = 60_000L;
    public static final int DEFAULT_MAX_RETRIES = 2;

    private final String baseUrl;
    private final long timeout;
    private final int maxRetries;
    private final Map<String, String> defaultHeaders;
    private final Map<String, String> defaultQuery;

    private ClientOptions(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.timeout = builder.timeout;
        this.maxRetries = builder.maxRetries;
        this.defaultHeaders = builder.defaultHeaders;
        this.defaultQuery = builder.defaultQuery;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public long getTimeout() {
        return timeout;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public Map<String, String> getDefaultHeaders() {
        return defaultHeaders;
    }

    public Map<String, String> getDefaultQuery() {
        return defaultQuery;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String baseUrl;
        private long timeout = DEFAULT_TIMEOUT;
        private int maxRetries = DEFAULT_MAX_RETRIES;
        private Map<String, String> defaultHeaders = new HashMap<>();
        private Map<String, String> defaultQuery = new HashMap<>();

        public Builder() {
            String envBaseUrl = System.getenv("OPENCODE_BASE_URL");
            this.baseUrl = envBaseUrl != null ? envBaseUrl : DEFAULT_BASE_URL;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder timeout(long timeoutMs) {
            this.timeout = timeoutMs;
            return this;
        }

        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        public Builder defaultHeader(String key, String value) {
            this.defaultHeaders.put(key, value);
            return this;
        }

        public Builder defaultHeaders(Map<String, String> headers) {
            this.defaultHeaders.putAll(headers);
            return this;
        }

        public Builder defaultQuery(String key, String value) {
            this.defaultQuery.put(key, value);
            return this;
        }

        public ClientOptions build() {
            return new ClientOptions(this);
        }
    }
}
