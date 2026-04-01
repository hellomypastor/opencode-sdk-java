package com.opencode.sdk.models.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageAbortedError {

    @JsonProperty("data")
    private Object data;

    @JsonProperty("name")
    private String name = "MessageAbortedError";

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
