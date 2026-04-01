package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToolPart {

    @JsonProperty("id")
    private String id;

    @JsonProperty("callID")
    private String callID;

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("state")
    private Object state;

    @JsonProperty("tool")
    private String tool;

    @JsonProperty("type")
    private String type = "tool";

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCallID() { return callID; }
    public void setCallID(String callID) { this.callID = callID; }
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public Object getState() { return state; }
    public void setState(Object state) { this.state = state; }
    public String getTool() { return tool; }
    public void setTool(String tool) { this.tool = tool; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
