package com.android.phuston.imgor.models;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String title;
    private String totalResults;
    private String searchTerms;
    private Integer count;
    private Integer startIndex;
    private String inputEncoding;
    private String outputEncoding;
    private String safe;
    private String cx;
    private String searchType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTitle() {
        return title;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getSearchTerms() {
        return searchTerms;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public String getInputEncoding() {
        return inputEncoding;
    }

    public String getOutputEncoding() {
        return outputEncoding;
    }

    public String getSafe() {
        return safe;
    }

    public String getCx() {
        return cx;
    }

    public String getSearchType() {
        return searchType;
    }

}