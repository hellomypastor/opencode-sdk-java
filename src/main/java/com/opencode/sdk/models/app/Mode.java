package com.opencode.sdk.models.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Mode {

    @JsonProperty("name")
    private String name;

    @JsonProperty("tools")
    private Map<String, Boolean> tools;

    @JsonProperty("model")
    private Model model;

    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("temperature")
    private Double temperature;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Map<String, Boolean> getTools() { return tools; }
    public void setTools(Map<String, Boolean> tools) { this.tools = tools; }

    public Model getModel() { return model; }
    public void setModel(Model model) { this.model = model; }

    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public static class Model {
        @JsonProperty("modelID")
        private String modelID;
        @JsonProperty("providerID")
        private String providerID;

        public String getModelID() { return modelID; }
        public void setModelID(String modelID) { this.modelID = modelID; }
        public String getProviderID() { return providerID; }
        public void setProviderID(String providerID) { this.providerID = providerID; }
    }
}
