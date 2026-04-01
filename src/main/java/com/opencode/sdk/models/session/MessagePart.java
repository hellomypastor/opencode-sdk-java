package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = TextPart.class, name = "text"),
    @JsonSubTypes.Type(value = StepStartPart.class, name = "step-start"),
    @JsonSubTypes.Type(value = StepFinishPart.class, name = "step-finish"),
    @JsonSubTypes.Type(value = ToolPart.class, name = "tool"),
    @JsonSubTypes.Type(value = FilePart.class, name = "file"),
    @JsonSubTypes.Type(value = PatchPart.class, name = "patch"),
    @JsonSubTypes.Type(value = SnapshotPart.class, name = "snapshot")
})
public abstract class MessagePart {
}
