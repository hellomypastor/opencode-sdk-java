package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SessionMessagesResponse {

    @JsonProperty("info")
    private Message info;

    @JsonProperty("parts")
    private List<MessagePart> parts;

    public Message getInfo() { return info; }
    public void setInfo(Message info) { this.info = info; }
    public List<MessagePart> getParts() { return parts; }
    public void setParts(List<MessagePart> parts) { this.parts = parts; }
}
