package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMessage {

    @JsonProperty("id")
    private String id;

    @JsonProperty("role")
    private String role = "user";

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("time")
    private Time time;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }

    public static class Time {
        @JsonProperty("created")
        private long created;

        public long getCreated() { return created; }
        public void setCreated(long created) { this.created = created; }
    }
}
