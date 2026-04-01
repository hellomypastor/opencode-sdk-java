package com.opencode.sdk.models.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class ModelInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("attachment")
    private boolean attachment;

    @JsonProperty("cost")
    private Cost cost;

    @JsonProperty("limit")
    private Limit limit;

    @JsonProperty("name")
    private String name;

    @JsonProperty("options")
    private Map<String, Object> options;

    @JsonProperty("reasoning")
    private boolean reasoning;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("temperature")
    private boolean temperature;

    @JsonProperty("tool_call")
    private boolean toolCall;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public boolean isAttachment() { return attachment; }
    public void setAttachment(boolean attachment) { this.attachment = attachment; }
    public Cost getCost() { return cost; }
    public void setCost(Cost cost) { this.cost = cost; }
    public Limit getLimit() { return limit; }
    public void setLimit(Limit limit) { this.limit = limit; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Map<String, Object> getOptions() { return options; }
    public void setOptions(Map<String, Object> options) { this.options = options; }
    public boolean isReasoning() { return reasoning; }
    public void setReasoning(boolean reasoning) { this.reasoning = reasoning; }
    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public boolean isTemperature() { return temperature; }
    public void setTemperature(boolean temperature) { this.temperature = temperature; }
    public boolean isToolCall() { return toolCall; }
    public void setToolCall(boolean toolCall) { this.toolCall = toolCall; }

    public static class Cost {
        @JsonProperty("input")
        private double input;
        @JsonProperty("output")
        private double output;
        @JsonProperty("cache_read")
        private Double cacheRead;
        @JsonProperty("cache_write")
        private Double cacheWrite;

        public double getInput() { return input; }
        public void setInput(double input) { this.input = input; }
        public double getOutput() { return output; }
        public void setOutput(double output) { this.output = output; }
        public Double getCacheRead() { return cacheRead; }
        public void setCacheRead(Double cacheRead) { this.cacheRead = cacheRead; }
        public Double getCacheWrite() { return cacheWrite; }
        public void setCacheWrite(Double cacheWrite) { this.cacheWrite = cacheWrite; }
    }

    public static class Limit {
        @JsonProperty("context")
        private int context;
        @JsonProperty("output")
        private int output;

        public int getContext() { return context; }
        public void setContext(int context) { this.context = context; }
        public int getOutput() { return output; }
        public void setOutput(int output) { this.output = output; }
    }
}
