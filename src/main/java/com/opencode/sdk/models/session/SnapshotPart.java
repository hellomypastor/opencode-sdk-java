package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SnapshotPart extends MessagePart {

    @JsonProperty("id")
    private String id;

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("snapshot")
    private String snapshot;

    @JsonProperty("type")
    private String type = "snapshot";

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public String getSnapshot() { return snapshot; }
    public void setSnapshot(String snapshot) { this.snapshot = snapshot; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
