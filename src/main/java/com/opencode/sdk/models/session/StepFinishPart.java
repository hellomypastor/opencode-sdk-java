package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StepFinishPart {

    @JsonProperty("id")
    private String id;

    @JsonProperty("cost")
    private double cost;

    @JsonProperty("messageID")
    private String messageID;

    @JsonProperty("sessionID")
    private String sessionID;

    @JsonProperty("tokens")
    private AssistantMessage.Tokens tokens;

    @JsonProperty("type")
    private String type = "step-finish";

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public AssistantMessage.Tokens getTokens() { return tokens; }
    public void setTokens(AssistantMessage.Tokens tokens) { this.tokens = tokens; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
