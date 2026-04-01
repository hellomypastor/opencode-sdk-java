package com.opencode.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.opencode.sdk.core.ApiResource;
import com.opencode.sdk.core.HttpClient;
import com.opencode.sdk.core.RequestOptions;
import com.opencode.sdk.models.find.FindTextMatch;
import com.opencode.sdk.models.find.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find files, symbols, and text.
 */
public class FindResource extends ApiResource {

    public FindResource(HttpClient client) {
        super(client);
    }

    /**
     * Find files matching a query.
     */
    public List<String> files(String query) {
        return files(query, null);
    }

    public List<String> files(String query, RequestOptions options) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("query", query);
        return client.get("/find/files", new TypeReference<List<String>>() {}, queryParams, options);
    }

    /**
     * Find workspace symbols.
     */
    public List<Symbol> symbols(String query) {
        return symbols(query, null);
    }

    public List<Symbol> symbols(String query, RequestOptions options) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("query", query);
        return client.get("/find/symbols", new TypeReference<List<Symbol>>() {}, queryParams, options);
    }

    /**
     * Find text in files.
     */
    public List<FindTextMatch> text(String pattern) {
        return text(pattern, null);
    }

    public List<FindTextMatch> text(String pattern, RequestOptions options) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("pattern", pattern);
        return client.get("/find/text", new TypeReference<List<FindTextMatch>>() {}, queryParams, options);
    }
}
