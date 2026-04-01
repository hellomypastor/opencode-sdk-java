package com.opencode.sdk;

import com.opencode.sdk.core.ClientOptions;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.resources.*;

/**
 * The official Java client for the Opencode API.
 *
 * <pre>{@code
 * Opencode client = new Opencode();
 *
 * // Get app info
 * App app = client.app().get();
 *
 * // Create and chat in a session
 * Session session = client.session().create();
 * SessionChatParams params = SessionChatParams.builder()
 *     .modelID("anthropic/claude-sonnet-4-20250514")
 *     .providerID("anthropic")
 *     .parts(List.of(new TextPartInput("Hello!")))
 *     .build();
 * client.session().chat(session.getId(), params);
 * }</pre>
 */
public class Opencode {

    private final HttpClient httpClient;
    private final AppResource app;
    private final SessionResource session;
    private final ConfigResource config;
    private final EventResource event;
    private final FileResource file;
    private final FindResource find;
    private final TuiResource tui;

    /**
     * Create a client with default options.
     * Base URL defaults to OPENCODE_BASE_URL env var or http://localhost:54321.
     */
    public Opencode() {
        this(ClientOptions.builder().build());
    }

    /**
     * Create a client with custom options.
     */
    public Opencode(ClientOptions options) {
        this.httpClient = new HttpClient(options);
        this.app = new AppResource(httpClient);
        this.session = new SessionResource(httpClient);
        this.config = new ConfigResource(httpClient);
        this.event = new EventResource(httpClient);
        this.file = new FileResource(httpClient);
        this.find = new FindResource(httpClient);
        this.tui = new TuiResource(httpClient);
    }

    /**
     * Create a client with a custom base URL.
     */
    public Opencode(String baseUrl) {
        this(ClientOptions.builder().baseUrl(baseUrl).build());
    }

    public AppResource app() { return app; }
    public SessionResource session() { return session; }
    public ConfigResource config() { return config; }
    public EventResource event() { return event; }
    public FileResource file() { return file; }
    public FindResource find() { return find; }
    public TuiResource tui() { return tui; }
}
