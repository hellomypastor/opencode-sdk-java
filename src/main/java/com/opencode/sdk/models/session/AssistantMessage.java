package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AssistantMessage {

    @JsonProperty("id")
    private String id;

    @JsonProperty("cost")
    private double cost;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("modelID")
    private String modelID;

    @JsonProperty("path")
    private Path path;

    @JsonProperty("providerID")
    private String providerID;

    @JsonProperty("role")
    private String role = "assistant";

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("system")
    private List<String> system;

    @JsonProperty("time")
    private Time time;

    @JsonProperty("tokens")
    private Tokens tokens;

    @JsonProperty("error")
    private Object error;

    @JsonProperty("summary")
    private Boolean summary;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
    public String getModelID() { return modelID; }
    public void setModelID(String modelID) { this.modelID = modelID; }
    public Path getPath() { return path; }
    public void setPath(Path path) { this.path = path; }
    public String getProviderID() { return providerID; }
    public void setProviderID(String providerID) { this.providerID = providerID; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public List<String> getSystem() { return system; }
    public void setSystem(List<String> system) { this.system = system; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
    public Tokens getTokens() { return tokens; }
    public void setTokens(Tokens tokens) { this.tokens = tokens; }
    public Object getError() { return error; }
    public void setError(Object error) { this.error = error; }
    public Boolean getSummary() { return summary; }
    public void setSummary(Boolean summary) { this.summary = summary; }

    public static class Path {
        @JsonProperty("cwd")
        private String cwd;
        @JsonProperty("root")
        private String root;

        public String getCwd() { return cwd; }
        public void setCwd(String cwd) { this.cwd = cwd; }
        public String getRoot() { return root; }
        public void setRoot(String root) { this.root = root; }
    }

    public static class Time {
        @JsonProperty("created")
        private long created;
        @JsonProperty("completed")
        private Long completed;

        public long getCreated() { return created; }
        public void setCreated(long created) { this.created = created; }
        public Long getCompleted() { return completed; }
        public void setCompleted(Long completed) { this.completed = completed; }
    }

    public static class Tokens {
        @JsonProperty("cache")
        private Cache cache;
        @JsonProperty("input")
        private int input;
        @JsonProperty("output")
        private int output;
        @JsonProperty("reasoning")
        private int reasoning;

        public Cache getCache() { return cache; }
        public void setCache(Cache cache) { this.cache = cache; }
        public int getInput() { return input; }
        public void setInput(int input) { this.input = input; }
        public int getOutput() { return output; }
        public void setOutput(int output) { this.output = output; }
        public int getReasoning() { return reasoning; }
        public void setReasoning(int reasoning) { this.reasoning = reasoning; }

        public static class Cache {
            @JsonProperty("read")
            private int read;
            @JsonProperty("write")
            private int write;

            public int getRead() { return read; }
            public void setRead(int read) { this.read = read; }
            public int getWrite() { return write; }
            public void setWrite(int write) { this.write = write; }
        }
    }
}
