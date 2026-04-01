package com.opencode.sdk.models.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class Provider {

    @JsonProperty("id")
    private String id;

    @JsonProperty("env")
    private List<String> env;

    @JsonProperty("models")
    private Map<String, ModelInfo> models;

    @JsonProperty("name")
    private String name;

    @JsonProperty("api")
    private String api;

    @JsonProperty("npm")
    private String npm;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<String> getEnv() { return env; }
    public void setEnv(List<String> env) { this.env = env; }
    public Map<String, ModelInfo> getModels() { return models; }
    public void setModels(Map<String, ModelInfo> models) { this.models = models; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getApi() { return api; }
    public void setApi(String api) { this.api = api; }
    public String getNpm() { return npm; }
    public void setNpm(String npm) { this.npm = npm; }
}
