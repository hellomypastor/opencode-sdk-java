package com.opencode.sdk.resources;

import com.opencode.sdk.core.ApiResource;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.RequestOptions;
import com.opencode.sdk.core.SseEventListener;
import com.opencode.sdk.models.event.EventListResponse;
import okhttp3.sse.EventSource;

/**
 * Stream server-sent events.
 */
public class EventResource extends ApiResource {

    public EventResource(HttpClient client) {
        super(client);
    }

    /**
     * List events (SSE stream).
     *
     * @param listener callback for SSE events
     * @return the EventSource (can be used to cancel the stream)
     */
    public EventSource list(SseEventListener<EventListResponse> listener) {
        return list(listener, null);
    }

    public EventSource list(SseEventListener<EventListResponse> listener, RequestOptions options) {
        return client.getStream("/event", new SseEventSourceListener<>(client, listener, EventListResponse.class), options);
    }
}
