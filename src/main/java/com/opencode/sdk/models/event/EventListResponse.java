package com.opencode.sdk.models.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * Represents an SSE event from the /event endpoint.
 * The "type" field discriminates between event kinds.
 */
public class EventListResponse {

    @JsonProperty("type")
    private String type;

    @JsonProperty("properties")
    private Map<String, Object> properties;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Map<String, Object> getProperties() { return properties; }
    public void setProperties(Map<String, Object> properties) { this.properties = properties; }
}
