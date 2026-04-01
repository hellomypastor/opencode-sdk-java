package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SymbolSource {

    @JsonProperty("kind")
    private int kind;

    @JsonProperty("name")
    private String name;

    @JsonProperty("path")
    private String path;

    @JsonProperty("range")
    private Range range;

    @JsonProperty("text")
    private FileSource.TextRange text;

    @JsonProperty("type")
    private String type = "symbol";

    public int getKind() { return kind; }
    public void setKind(int kind) { this.kind = kind; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public Range getRange() { return range; }
    public void setRange(Range range) { this.range = range; }
    public FileSource.TextRange getText() { return text; }
    public void setText(FileSource.TextRange text) { this.text = text; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public static class Range {
        @JsonProperty("end")
        private Position end;
        @JsonProperty("start")
        private Position start;

        public Position getEnd() { return end; }
        public void setEnd(Position end) { this.end = end; }
        public Position getStart() { return start; }
        public void setStart(Position start) { this.start = start; }
    }

    public static class Position {
        @JsonProperty("character")
        private int character;
        @JsonProperty("line")
        private int line;

        public int getCharacter() { return character; }
        public void setCharacter(int character) { this.character = character; }
        public int getLine() { return line; }
        public void setLine(int line) { this.line = line; }
    }
}
