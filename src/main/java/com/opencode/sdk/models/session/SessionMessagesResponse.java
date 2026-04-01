package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SessionMessagesResponse {

    @JsonProperty("info")
    private Object info;

    @JsonProperty("parts")
    private List<Object> parts;

    public Object getInfo() { return info; }
    public void setInfo(Object info) { this.info = info; }
    public List<Object> getParts() { return parts; }
    public void setParts(List<Object> parts) { this.parts = parts; }
}
