package com.opencode.sdk.models.file;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileReadResponse {

    @JsonProperty("content")
    private String content;

    @JsonProperty("type")
    private String type;

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
