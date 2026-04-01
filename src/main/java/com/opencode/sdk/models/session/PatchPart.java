package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PatchPart {

    @JsonProperty("id")
    private String id;

    @JsonProperty("files")
    private List<String> files;

    @JsonProperty("hash")
    private String hash;

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("type")
    private String type = "patch";

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<String> getFiles() { return files; }
    public void setFiles(List<String> files) { this.files = files; }
    public String getHash() { return hash; }
    public void setHash(String hash) { this.hash = hash; }
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
