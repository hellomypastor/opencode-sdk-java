package com.opencode.sdk.models.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class App {

    @JsonProperty("git")
    private boolean git;

    @JsonProperty("hostname")
    private String hostname;

    @JsonProperty("path")
    private Path path;

    @JsonProperty("time")
    private Time time;

    public boolean isGit() { return git; }
    public void setGit(boolean git) { this.git = git; }

    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }

    public Path getPath() { return path; }
    public void setPath(Path path) { this.path = path; }

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }

    public static class Path {
        @JsonProperty("config")
        private String config;
        @JsonProperty("cwd")
        private String cwd;
        @JsonProperty("data")
        private String data;
        @JsonProperty("root")
        private String root;
        @JsonProperty("state")
        private String state;

        public String getConfig() { return config; }
        public void setConfig(String config) { this.config = config; }
        public String getCwd() { return cwd; }
        public void setCwd(String cwd) { this.cwd = cwd; }
        public String getData() { return data; }
        public void setData(String data) { this.data = data; }
        public String getRoot() { return root; }
        public void setRoot(String root) { this.root = root; }
        public String getState() { return state; }
        public void setState(String state) { this.state = state; }
    }

    public static class Time {
        @JsonProperty("initialized")
        private Long initialized;

        public Long getInitialized() { return initialized; }
        public void setInitialized(Long initialized) { this.initialized = initialized; }
    }
}
