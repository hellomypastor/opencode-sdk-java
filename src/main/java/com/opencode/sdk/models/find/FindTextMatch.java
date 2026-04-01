package com.opencode.sdk.models.find;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FindTextMatch {

    @JsonProperty("absoluteOffset")
    private int absoluteOffset;

    @JsonProperty("lineNumber")
    private int lineNumber;

    @JsonProperty("path")
    private String path;

    @JsonProperty("lines")
    private String lines;

    @JsonProperty("submatches")
    private List<Submatch> submatches;

    public int getAbsoluteOffset() { return absoluteOffset; }
    public void setAbsoluteOffset(int absoluteOffset) { this.absoluteOffset = absoluteOffset; }
    public int getLineNumber() { return lineNumber; }
    public void setLineNumber(int lineNumber) { this.lineNumber = lineNumber; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public String getLines() { return lines; }
    public void setLines(String lines) { this.lines = lines; }
    public List<Submatch> getSubmatches() { return submatches; }
    public void setSubmatches(List<Submatch> submatches) { this.submatches = submatches; }

    public static class Submatch {
        @JsonProperty("match")
        private String match;
        @JsonProperty("start")
        private int start;
        @JsonProperty("end")
        private int end;

        public String getMatch() { return match; }
        public void setMatch(String match) { this.match = match; }
        public int getStart() { return start; }
        public void setStart(int start) { this.start = start; }
        public int getEnd() { return end; }
        public void setEnd(int end) { this.end = end; }
    }
}
