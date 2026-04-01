package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class ToolStateError {

    @JsonProperty("error")
    private String error;

    @JsonProperty("input")
    private Map<String, Object> input;

    @JsonProperty("status")
    private String status = "error";

    @JsonProperty("time")
    private Time time;

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public Map<String, Object> getInput() { return input; }
    public void setInput(Map<String, Object> input) { this.input = input; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }

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
