package com.opencode.sdk.models.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Session {

    @JsonProperty("id")
    private String id;

    @JsonProperty("time")
    private Time time;

    @JsonProperty("title")
    private String title;

    @JsonProperty("version")
    private String version;

    @JsonProperty("parentID")
    private String parentID;

    @JsonProperty("revert")
    private Revert revert;

    @JsonProperty("share")
    private Share share;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getParentID() { return parentID; }
    public void setParentID(String parentID) { this.parentID = parentID; }
    public Revert getRevert() { return revert; }
    public void setRevert(Revert revert) { this.revert = revert; }
    public Share getShare() { return share; }
    public void setShare(Share share) { this.share = share; }

    public static class Time {
        @JsonProperty("created")
        private long created;
        @JsonProperty("updated")
        private long updated;

        public long getCreated() { return created; }
        public void setCreated(long created) { this.created = created; }
        public long getUpdated() { return updated; }
        public void setUpdated(long updated) { this.updated = updated; }
    }

    public static class Revert {
        @JsonProperty("messageID")
        private String messageID;
        @JsonProperty("diff")
        private String diff;
        @JsonProperty("partID")
        private String partID;
        @JsonProperty("snapshot")
        private String snapshot;

        public String getMessageID() { return messageID; }
        public void setMessageID(String messageID) { this.messageID = messageID; }
        public String getDiff() { return diff; }
        public void setDiff(String diff) { this.diff = diff; }
        public String getPartID() { return partID; }
        public void setPartID(String partID) { this.partID = partID; }
        public String getSnapshot() { return snapshot; }
        public void setSnapshot(String snapshot) { this.snapshot = snapshot; }
    }

    public static class Share {
        @JsonProperty("url")
        private String url;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }
}
