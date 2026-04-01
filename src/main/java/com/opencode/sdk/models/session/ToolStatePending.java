package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToolStatePending {

    @JsonProperty("status")
    private String status = "pending";

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
