package com.opencode.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.opencode.sdk.core.ApiResource;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.RequestOptions;
import com.opencode.sdk.models.file.FileInfo;
import com.opencode.sdk.models.file.FileReadResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Read files and check file status.
 */
public class FileResource extends ApiResource {

    public FileResource(HttpClient client) {
        super(client);
    }

    /**
     * Read a file's content.
     */
    public FileReadResponse read(String path) {
        return read(path, null);
    }

    public FileReadResponse read(String path, RequestOptions options) {
        Map<String, String> query = new HashMap<>();
        query.put("path", path);
        return client.get("/file", FileReadResponse.class, query, options);
    }

    /**
     * Get file status (list of changed files).
     */
    public List<FileInfo> status() {
        return status(null);
    }

    public List<FileInfo> status(RequestOptions options) {
        return client.get("/file/status", new TypeReference<List<FileInfo>>() {}, options);
    }
}
