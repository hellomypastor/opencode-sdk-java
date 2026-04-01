package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMessage extends Message {

    @JsonProperty("time")
    private Time time;

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }

    public static class Time {
        @JsonProperty("created")
        private long created;

        public long getCreated() { return created; }
        public void setCreated(long created) { this.created = created; }
    }
}
