package com.android.phuston.imgor.models;

import java.util.HashMap;
import java.util.Map;

public class SearchInformation {

    private Double searchTime;
    private String formattedSearchTime;
    private String totalResults;
    private String formattedTotalResults;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getSearchTime() {
        return searchTime;
    }

    public String getFormattedSearchTime() {
        return formattedSearchTime;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getFormattedTotalResults() {
        return formattedTotalResults;
    }
}