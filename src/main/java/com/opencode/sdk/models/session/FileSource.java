package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileSource {

    @JsonProperty("path")
    private String path;

    @JsonProperty("text")
    private TextRange text;

    @JsonProperty("type")
    private String type = "file";

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public TextRange getText() { return text; }
    public void setText(TextRange text) { this.text = text; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public static class TextRange {
        @JsonProperty("end")
        private int end;
        @JsonProperty("start")
        private int start;
        @JsonProperty("value")
        private String value;

        public int getEnd() { return end; }
        public void setEnd(int end) { this.end = end; }
        public int getStart() { return start; }
        public void setStart(int start) { this.start = start; }
        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }
}
