package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionSummarizeParams {

    @JsonProperty("modelID")
    private String modelID;

    @JsonProperty("providerID")
    private String providerID;

    public SessionSummarizeParams() {}

    public SessionSummarizeParams(String modelID, String providerID) {
        this.modelID = modelID;
        this.providerID = providerID;
    }

    public String getModelID() { return modelID; }
    public void setModelID(String modelID) { this.modelID = modelID; }
    public String getProviderID() { return providerID; }
    public void setProviderID(String providerID) { this.providerID = providerID; }
}
