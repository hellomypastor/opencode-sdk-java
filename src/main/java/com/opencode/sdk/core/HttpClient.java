package com.opencode.sdk.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencode.sdk.errors.*;
import okhttp3.*;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Low-level HTTP client that handles requests, retries, and error mapping.
 */
public class HttpClient {

    private final OkHttpClient httpClient;
    private final ClientOptions options;
    private final ObjectMapper objectMapper;

    public HttpClient(ClientOptions options) {
        this.options = options;
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(options.getTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(options.getTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(options.getTimeout(), TimeUnit.MILLISECONDS)
                .build();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    // ---- GET ----

    public <T> T get(String path, Class<T> responseType, RequestOptions reqOptions) {
        return execute("GET", path, null, responseType, reqOptions);
    }

    public <T> T get(String path, TypeReference<T> responseType, RequestOptions reqOptions) {
        return execute("GET", path, null, responseType, reqOptions);
    }

    public <T> T get(String path, Class<T> responseType, Map<String, String> query, RequestOptions reqOptions) {
        return execute("GET", buildPathWithQuery(path, query), null, responseType, reqOptions);
    }

    public <T> T get(String path, TypeReference<T> responseType, Map<String, String> query, RequestOptions reqOptions) {
        return execute("GET", buildPathWithQuery(path, query), null, responseType, reqOptions);
    }

    // ---- POST ----

    public <T> T post(String path, Object body, Class<T> responseType, RequestOptions reqOptions) {
        return execute("POST", path, body, responseType, reqOptions);
    }

    public <T> T post(String path, Object body, TypeReference<T> responseType, RequestOptions reqOptions) {
        return execute("POST", path, body, responseType, reqOptions);
    }

    public <T> T post(String path, Class<T> responseType, RequestOptions reqOptions) {
        return execute("POST", path, null, responseType, reqOptions);
    }

    // ---- PATCH ----

    public <T> T patch(String path, Object body, Class<T> responseType, RequestOptions reqOptions) {
        return execute("PATCH", path, body, responseType, reqOptions);
    }

    // ---- PUT ----

    public <T> T put(String path, Object body, Class<T> responseType, RequestOptions reqOptions) {
        return execute("PUT", path, body, responseType, reqOptions);
    }

    // ---- DELETE ----

    public <T> T delete(String path, Class<T> responseType, RequestOptions reqOptions) {
        return execute("DELETE", path, null, responseType, reqOptions);
    }

    public <T> T delete(String path, TypeReference<T> responseType, RequestOptions reqOptions) {
        return execute("DELETE", path, null, responseType, reqOptions);
    }

    // ---- SSE Streaming ----

    public EventSource getStream(String path, EventSourceListener listener, RequestOptions reqOptions) {
        String url = buildUrl(path);
        Request.Builder requestBuilder = new Request.Builder().url(url).get();
        applyHeaders(requestBuilder, reqOptions);

        Request request = requestBuilder.build();
        EventSource.Factory factory = EventSources.createFactory(httpClient);
        return factory.newEventSource(request, listener);
    }

    // ---- Internal ----

    private <T> T execute(String method, String path, Object body, Class<T> responseType, RequestOptions reqOptions) {
        int maxRetries = reqOptions != null && reqOptions.getMaxRetries() != null
                ? reqOptions.getMaxRetries()
                : options.getMaxRetries();

        IOException lastException = null;
        for (int attempt = 0; attempt <= maxRetries; attempt++) {
            try {
                Response response = doRequest(method, path, body, reqOptions);
                return handleResponse(response, responseType);
            } catch (IOException e) {
                lastException = e;
                if (attempt < maxRetries) {
                    sleepForRetry(attempt);
                }
            }
        }
        throw new ApiConnectionError("Connection failed after " + (maxRetries + 1) + " attempts", lastException);
    }

    private <T> T execute(String method, String path, Object body, TypeReference<T> responseType, RequestOptions reqOptions) {
        int maxRetries = reqOptions != null && reqOptions.getMaxRetries() != null
                ? reqOptions.getMaxRetries()
                : options.getMaxRetries();

        IOException lastException = null;
        for (int attempt = 0; attempt <= maxRetries; attempt++) {
            try {
                Response response = doRequest(method, path, body, reqOptions);
                return handleResponse(response, responseType);
            } catch (IOException e) {
                lastException = e;
                if (attempt < maxRetries) {
                    sleepForRetry(attempt);
                }
            }
        }
        throw new ApiConnectionError("Connection failed after " + (maxRetries + 1) + " attempts", lastException);
    }

    private Response doRequest(String method, String path, Object body, RequestOptions reqOptions) throws IOException {
        String url = buildUrl(path);
        Request.Builder requestBuilder = new Request.Builder().url(url);

        RequestBody requestBody = null;
        if (body != null) {
            String json = objectMapper.writeValueAsString(body);
            requestBody = RequestBody.create(json, MediaType.parse("application/json"));
        }

        switch (method) {
            case "GET":
                requestBuilder.get();
                break;
            case "POST":
                requestBuilder.post(requestBody != null ? requestBody : emptyJsonBody());
                break;
            case "PATCH":
                requestBuilder.patch(requestBody != null ? requestBody : emptyJsonBody());
                break;
            case "PUT":
                requestBuilder.put(requestBody != null ? requestBody : emptyJsonBody());
                break;
            case "DELETE":
                requestBuilder.delete(requestBody);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }

        applyHeaders(requestBuilder, reqOptions);
        return httpClient.newCall(requestBuilder.build()).execute();
    }

    private RequestBody emptyJsonBody() {
        return RequestBody.create("{}", MediaType.parse("application/json"));
    }

    private void applyHeaders(Request.Builder requestBuilder, RequestOptions reqOptions) {
        for (Map.Entry<String, String> entry : options.getDefaultHeaders().entrySet()) {
            requestBuilder.header(entry.getKey(), entry.getValue());
        }
        if (reqOptions != null && reqOptions.getHeaders() != null) {
            for (Map.Entry<String, String> entry : reqOptions.getHeaders().entrySet()) {
                requestBuilder.header(entry.getKey(), entry.getValue());
            }
        }
    }

    private <T> T handleResponse(Response response, Class<T> responseType) throws IOException {
        ResponseBody responseBody = response.body();
        String bodyStr = responseBody != null ? responseBody.string() : "";

        if (!response.isSuccessful()) {
            throwApiError(response.code(), bodyStr);
        }

        if (responseType == Void.class) {
            return null;
        }
        return objectMapper.readValue(bodyStr, responseType);
    }

    private <T> T handleResponse(Response response, TypeReference<T> responseType) throws IOException {
        ResponseBody responseBody = response.body();
        String bodyStr = responseBody != null ? responseBody.string() : "";

        if (!response.isSuccessful()) {
            throwApiError(response.code(), bodyStr);
        }

        return objectMapper.readValue(bodyStr, responseType);
    }

    private void throwApiError(int statusCode, String body) {
        switch (statusCode) {
            case 400:
                throw new BadRequestError(body, statusCode);
            case 401:
                throw new AuthenticationError(body, statusCode);
            case 403:
                throw new PermissionDeniedError(body, statusCode);
            case 404:
                throw new NotFoundError(body, statusCode);
            case 409:
                throw new ConflictError(body, statusCode);
            case 422:
                throw new UnprocessableEntityError(body, statusCode);
            case 429:
                throw new RateLimitError(body, statusCode);
            default:
                if (statusCode >= 500) {
                    throw new InternalServerError(body, statusCode);
                }
                throw new ApiError(body, statusCode);
        }
    }

    private String buildUrl(String path) {
        String base = options.getBaseUrl();
        if (base.endsWith("/")) {
            base = base.substring(0, base.length() - 1);
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return base + path;
    }

    private String buildPathWithQuery(String path, Map<String, String> queryParams) {
        if (queryParams == null || queryParams.isEmpty()) {
            return path;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append("?");
        boolean first = true;
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            if (!first) sb.append("&");
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }

    private void sleepForRetry(int attempt) {
        try {
            long delay = (long) (Math.pow(2, attempt) * 500);
            Thread.sleep(Math.min(delay, 8000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
