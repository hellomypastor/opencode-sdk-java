package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionRevertParams {

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("partID")
    private String partID;

    public SessionRevertParams() {}

    public SessionRevertParams(String messageID) {
        this.messageID = messageID;
    }

    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getPartID() { return partID; }
    public void setPartID(String partID) { this.partID = partID; }
}
