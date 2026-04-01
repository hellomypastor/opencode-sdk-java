package com.opencode.sdk.models.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class Config {

    @JsonProperty("$schema")
    private String schema;

    @JsonProperty("autoshare")
    private Boolean autoshare;

    @JsonProperty("autoupdate")
    private Boolean autoupdate;

    @JsonProperty("disabled_providers")
    private List<String> disabledProviders;

    @JsonProperty("instructions")
    private List<String> instructions;

    @JsonProperty("keybinds")
    private Map<String, String> keybinds;

    @JsonProperty("layout")
    private String layout;

    @JsonProperty("mcp")
    private Map<String, Object> mcp;

    @JsonProperty("model")
    private String model;

    @JsonProperty("provider")
    private Map<String, Object> provider;

    @JsonProperty("share")
    private String share;

    @JsonProperty("small_model")
    private String smallModel;

    @JsonProperty("theme")
    private String theme;

    @JsonProperty("username")
    private String username;

    public String getSchema() { return schema; }
    public void setSchema(String schema) { this.schema = schema; }
    public Boolean getAutoshare() { return autoshare; }
    public void setAutoshare(Boolean autoshare) { this.autoshare = autoshare; }
    public Boolean getAutoupdate() { return autoupdate; }
    public void setAutoupdate(Boolean autoupdate) { this.autoupdate = autoupdate; }
    public List<String> getDisabledProviders() { return disabledProviders; }
    public void setDisabledProviders(List<String> disabledProviders) { this.disabledProviders = disabledProviders; }
    public List<String> getInstructions() { return instructions; }
    public void setInstructions(List<String> instructions) { this.instructions = instructions; }
    public Map<String, String> getKeybinds() { return keybinds; }
    public void setKeybinds(Map<String, String> keybinds) { this.keybinds = keybinds; }
    public String getLayout() { return layout; }
    public void setLayout(String layout) { this.layout = layout; }
    public Map<String, Object> getMcp() { return mcp; }
    public void setMcp(Map<String, Object> mcp) { this.mcp = mcp; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Map<String, Object> getProvider() { return provider; }
    public void setProvider(Map<String, Object> provider) { this.provider = provider; }
    public String getShare() { return share; }
    public void setShare(String share) { this.share = share; }
    public String getSmallModel() { return smallModel; }
    public void setSmallModel(String smallModel) { this.smallModel = smallModel; }
    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
