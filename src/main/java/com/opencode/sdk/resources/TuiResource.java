package com.opencode.sdk.resources;

import com.opencode.sdk.core.ApiResource;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.RequestOptions;
import com.opencode.sdk.models.tui.TuiAppendPromptParams;

/**
 * Interact with the terminal UI.
 */
public class TuiResource extends ApiResource {

    public TuiResource(HttpClient client) {
        super(client);
    }

    /**
     * Append text to the TUI prompt.
     */
    public boolean appendPrompt(TuiAppendPromptParams params) {
        return appendPrompt(params, null);
    }

    public boolean appendPrompt(TuiAppendPromptParams params, RequestOptions options) {
        return client.post("/tui/append-prompt", params, Boolean.class, options);
    }

    /**
     * Open help in the TUI.
     */
    public boolean openHelp() {
        return openHelp(null);
    }

    public boolean openHelp(RequestOptions options) {
        return client.post("/tui/open-help", Boolean.class, options);
    }
}
