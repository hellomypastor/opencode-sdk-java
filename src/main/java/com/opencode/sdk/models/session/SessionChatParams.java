package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class SessionChatParams {

    @JsonProperty("modelID")
    private String modelID;

    @JsonProperty("parts")
    private List<Object> parts;

    @JsonProperty("providerID")
    private String providerID;

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("system")
    private String system;

    @JsonProperty("tools")
    private Map<String, Boolean> tools;

    public SessionChatParams() {}

    public String getModelID() { return modelID; }
    public void setModelID(String modelID) { this.modelID = modelID; }
    public List<Object> getParts() { return parts; }
    public void setParts(List<Object> parts) { this.parts = parts; }
    public String getProviderID() { return providerID; }
    public void setProviderID(String providerID) { this.providerID = providerID; }
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
    public String getSystem() { return system; }
    public void setSystem(String system) { this.system = system; }
    public Map<String, Boolean> getTools() { return tools; }
    public void setTools(Map<String, Boolean> tools) { this.tools = tools; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SessionChatParams params = new SessionChatParams();

        public Builder modelID(String modelID) { params.modelID = modelID; return this; }
        public Builder parts(List<Object> parts) { params.parts = parts; return this; }
        public Builder providerID(String providerID) { params.providerID = providerID; return this; }
        public Builder messageID(String messageID) { params.messageID = messageID; return this; }
        public Builder mode(String mode) { params.mode = mode; return this; }
        public Builder system(String system) { params.system = system; return this; }
        public Builder tools(Map<String, Boolean> tools) { params.tools = tools; return this; }
        public SessionChatParams build() { return params; }
    }
}
