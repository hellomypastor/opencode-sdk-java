package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StepStartPart extends MessagePart {

    @JsonProperty("id")
    private String id;

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("type")
    private String type = "step-start";

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
