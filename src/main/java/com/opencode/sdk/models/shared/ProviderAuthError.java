package com.opencode.sdk.models.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderAuthError {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("name")
    private String name = "ProviderAuthError";

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static class Data {
        @JsonProperty("message")
        private String message;

        @JsonProperty("providerID")
        private String providerID;

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }

        public String getProviderID() { return providerID; }
        public void setProviderID(String providerID) { this.providerID = providerID; }
    }
}
