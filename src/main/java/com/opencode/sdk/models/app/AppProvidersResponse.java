package com.opencode.sdk.models.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class AppProvidersResponse {

    @JsonProperty("default")
    private Map<String, String> defaultModels;

    @JsonProperty("providers")
    private List<Provider> providers;

    public Map<String, String> getDefaultModels() { return defaultModels; }
    public void setDefaultModels(Map<String, String> defaultModels) { this.defaultModels = defaultModels; }

    public List<Provider> getProviders() { return providers; }
    public void setProviders(List<Provider> providers) { this.providers = providers; }
}
