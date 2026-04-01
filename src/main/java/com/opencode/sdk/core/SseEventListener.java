package com.opencode.sdk.core;

/**
 * Callback interface for receiving Server-Sent Events.
 */
public interface SseEventListener<T> {

    /**
     * Called when a new event is received.
     */
    void onEvent(T event);

    /**
     * Called when the stream is opened.
     */
    default void onOpen() {}

    /**
     * Called when the stream is closed.
     */
    default void onClosed() {}

    /**
     * Called when an error occurs.
     */
    default void onError(Throwable t) {}
}
