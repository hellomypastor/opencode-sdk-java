package com.opencode.sdk.models.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class AppLogParams {

    @JsonProperty("level")
    private String level;

    @JsonProperty("message")
    private String message;

    @JsonProperty("service")
    private String service;

    @JsonProperty("extra")
    private Map<String, Object> extra;

    public AppLogParams() {}

    public AppLogParams(String level, String message, String service) {
        this.level = level;
        this.message = message;
        this.service = service;
    }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
    public Map<String, Object> getExtra() { return extra; }
    public void setExtra(Map<String, Object> extra) { this.extra = extra; }
}
