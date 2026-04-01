package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextPartInput {

    @JsonProperty("text")
    private String text;

    @JsonProperty("type")
    private String type = "text";

    @JsonProperty("id")
    private String id;

    @JsonProperty("synthetic")
    private Boolean synthetic;

    public TextPartInput() {}

    public TextPartInput(String text) {
        this.text = text;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Boolean getSynthetic() { return synthetic; }
    public void setSynthetic(Boolean synthetic) { this.synthetic = synthetic; }
}
