package com.opencode.sdk.models.file;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileReadParams {

    @JsonProperty("path")
    private String path;

    public FileReadParams() {}

    public FileReadParams(String path) {
        this.path = path;
    }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
}
