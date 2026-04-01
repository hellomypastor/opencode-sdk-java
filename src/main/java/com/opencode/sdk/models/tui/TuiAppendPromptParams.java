package com.opencode.sdk.models.tui;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TuiAppendPromptParams {

    @JsonProperty("text")
    private String text;

    public TuiAppendPromptParams() {}

    public TuiAppendPromptParams(String text) {
        this.text = text;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
