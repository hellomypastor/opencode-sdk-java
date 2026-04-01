package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class ToolStateCompleted {

    @JsonProperty("input")
    private Map<String, Object> input;

    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @JsonProperty("output")
    private String output;

    @JsonProperty("status")
    private String status = "completed";

    @JsonProperty("time")
    private Time time;

    @JsonProperty("title")
    private String title;

    public Map<String, Object> getInput() { return input; }
    public void setInput(Map<String, Object> input) { this.input = input; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public static class Time {
        @JsonProperty("end")
        private long end;
        @JsonProperty("start")
        private long start;

        public long getEnd() { return end; }
        public void setEnd(long end) { this.end = end; }
        public long getStart() { return start; }
        public void setStart(long start) { this.start = start; }
    }
}
