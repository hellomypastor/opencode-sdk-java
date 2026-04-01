package com.opencode.sdk.models.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnknownError {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("name")
    private String name = "UnknownError";

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static class Data {
        @JsonProperty("message")
        private String message;

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}
