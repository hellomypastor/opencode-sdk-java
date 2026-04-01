package com.opencode.sdk.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Options that can be passed to individual API requests.
 */
public class RequestOptions {

    private final Map<String, String> headers;
    private final Map<String, String> query;
    private final Long timeout;
    private final Integer maxRetries;

    private RequestOptions(Builder builder) {
        this.headers = builder.headers;
        this.query = builder.query;
        this.timeout = builder.timeout;
        this.maxRetries = builder.maxRetries;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public Long getTimeout() {
        return timeout;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> query = new HashMap<>();
        private Long timeout;
        private Integer maxRetries;

        public Builder header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers.putAll(headers);
            return this;
        }

        public Builder query(String key, String value) {
            this.query.put(key, value);
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

        public RequestOptions build() {
            return new RequestOptions(this);
        }
    }
}
