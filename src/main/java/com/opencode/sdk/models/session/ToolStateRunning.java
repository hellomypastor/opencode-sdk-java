package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class ToolStateRunning {

    @JsonProperty("status")
    private String status = "running";

    @JsonProperty("time")
    private Time time;

    @JsonProperty("input")
    private Object input;

    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @JsonProperty("title")
    private String title;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
    public Object getInput() { return input; }
    public void setInput(Object input) { this.input = input; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public static class Time {
        @JsonProperty("start")
        private long start;

        public long getStart() { return start; }
        public void setStart(long start) { this.start = start; }
    }
}
