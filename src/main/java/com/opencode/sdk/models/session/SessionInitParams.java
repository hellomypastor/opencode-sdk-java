package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionInitParams {

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("modelID")
    private String modelID;

    @JsonProperty("providerID")
    private String providerID;

    public SessionInitParams() {}

    public SessionInitParams(String messageID, String modelID, String providerID) {
        this.messageID = messageID;
        this.modelID = modelID;
        this.providerID = providerID;
    }

    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getModelID() { return modelID; }
    public void setModelID(String modelID) { this.modelID = modelID; }
    public String getProviderID() { return providerID; }
    public void setProviderID(String providerID) { this.providerID = providerID; }
}
