package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilePartInput {

    @JsonProperty("mime")
    private String mime;

    @JsonProperty("type")
    private String type = "file";

    @JsonProperty("url")
    private String url;

    @JsonProperty("id")
    private String id;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("source")
    private Object source;

    public FilePartInput() {}

    public FilePartInput(String mime, String url) {
        this.mime = mime;
        this.url = url;
    }

    public String getMime() { return mime; }
    public void setMime(String mime) { this.mime = mime; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }
    public Object getSource() { return source; }
    public void setSource(Object source) { this.source = source; }
}
