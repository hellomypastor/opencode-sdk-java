package com.opencode.sdk.resources;

import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.SseEventListener;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

/**
 * Bridges OkHttp SSE events to our typed SseEventListener.
 */
class SseEventSourceListener<T> extends EventSourceListener {

    private final HttpClient client;
    private final SseEventListener<T> listener;
    private final Class<T> type;

    SseEventSourceListener(HttpClient client, SseEventListener<T> listener, Class<T> type) {
        this.client = client;
        this.listener = listener;
        this.type = type;
    }

    @Override
    public void onOpen(EventSource eventSource, Response response) {
        listener.onOpen();
    }

    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        try {
            T parsed = client.getObjectMapper().readValue(data, this.type);
            listener.onEvent(parsed);
        } catch (Exception e) {
            listener.onError(e);
        }
    }

    @Override
    public void onClosed(EventSource eventSource) {
        listener.onClosed();
    }

    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        listener.onError(t);
    }
}
