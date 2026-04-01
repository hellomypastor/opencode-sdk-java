package com.opencode.sdk.models.file;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileInfo {

    @JsonProperty("added")
    private int added;

    @JsonProperty("path")
    private String path;

    @JsonProperty("removed")
    private int removed;

    @JsonProperty("status")
    private String status;

    public int getAdded() { return added; }
    public void setAdded(int added) { this.added = added; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public int getRemoved() { return removed; }
    public void setRemoved(int removed) { this.removed = removed; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
