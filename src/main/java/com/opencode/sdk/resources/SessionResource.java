package com.opencode.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.opencode.sdk.core.ApiResource;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.RequestOptions;
import com.opencode.sdk.models.session.*;

import java.util.List;

/**
 * Manage sessions and conversations.
 */
public class SessionResource extends ApiResource {

    public SessionResource(HttpClient client) {
        super(client);
    }

    /**
     * Create a new session.
     */
    public Session create() {
        return create(null);
    }

    public Session create(RequestOptions options) {
        return client.post("/session", Session.class, options);
    }

    /**
     * List all sessions.
     */
    public List<Session> list() {
        return list(null);
    }

    public List<Session> list(RequestOptions options) {
        return client.get("/session", new TypeReference<List<Session>>() {}, options);
    }

    /**
     * Delete a session and all associated data.
     */
    public boolean delete(String id) {
        return delete(id, null);
    }

    public boolean delete(String id, RequestOptions options) {
        return client.delete("/session/" + id, Boolean.class, options);
    }

    /**
     * Abort a session.
     */
    public boolean abort(String id) {
        return abort(id, null);
    }

    public boolean abort(String id, RequestOptions options) {
        return client.post("/session/" + id + "/abort", Boolean.class, options);
    }

    /**
     * Send a message to a session.
     */
    public SessionMessagesResponse chat(String id, SessionChatParams params) {
        return chat(id, params, null);
    }

    public SessionMessagesResponse chat(String id, SessionChatParams params, RequestOptions options) {
        return client.post("/session/" + id + "/message", params, SessionMessagesResponse.class, options);
    }

    /**
     * Analyze the app and generate AGENTS.md.
     */
    public boolean init(String id, SessionInitParams params) {
        return init(id, params, null);
    }

    public boolean init(String id, SessionInitParams params, RequestOptions options) {
        return client.post("/session/" + id + "/init", params, Boolean.class, options);
    }

    /**
     * Get all messages in a session.
     */
    public List<SessionMessagesResponse> messages(String id) {
        return messages(id, null);
    }

    public List<SessionMessagesResponse> messages(String id, RequestOptions options) {
        return client.get("/session/" + id + "/message", new TypeReference<List<SessionMessagesResponse>>() {}, options);
    }

    /**
     * Revert a message.
     */
    public Session revert(String id, SessionRevertParams params) {
        return revert(id, params, null);
    }

    public Session revert(String id, SessionRevertParams params, RequestOptions options) {
        return client.post("/session/" + id + "/revert", params, Session.class, options);
    }

    /**
     * Share a session.
     */
    public Session share(String id) {
        return share(id, null);
    }

    public Session share(String id, RequestOptions options) {
        return client.post("/session/" + id + "/share", Session.class, options);
    }

    /**
     * Summarize a session.
     */
    public boolean summarize(String id, SessionSummarizeParams params) {
        return summarize(id, params, null);
    }

    public boolean summarize(String id, SessionSummarizeParams params, RequestOptions options) {
        return client.post("/session/" + id + "/summarize", params, Boolean.class, options);
    }

    /**
     * Unrevert a message.
     */
    public Session unrevert(String id) {
        return unrevert(id, null);
    }

    public Session unrevert(String id, RequestOptions options) {
        return client.post("/session/" + id + "/unrevert", Session.class, options);
    }

    /**
     * Unshare a session.
     */
    public Session unshare(String id) {
        return unshare(id, null);
    }

    public Session unshare(String id, RequestOptions options) {
        return client.post("/session/" + id + "/unshare", Session.class, options);
    }
}
