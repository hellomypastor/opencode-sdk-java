package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextPart extends MessagePart {

    @JsonProperty("id")
    private String id;

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("text")
    private String text;

    @JsonProperty("type")
    private String type = "text";

    @JsonProperty("synthetic")
    private Boolean synthetic;

    @JsonProperty("time")
    private Time time;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Boolean getSynthetic() { return synthetic; }
    public void setSynthetic(Boolean synthetic) { this.synthetic = synthetic; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }

    public static class Time {
        @JsonProperty("start")
        private long start;
        @JsonProperty("end")
        private Long end;

        public long getStart() { return start; }
        public void setStart(long start) { this.start = start; }
        public Long getEnd() { return end; }
        public void setEnd(Long end) { this.end = end; }
    }
}
