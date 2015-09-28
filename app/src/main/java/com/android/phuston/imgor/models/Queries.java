package com.android.phuston.imgor.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Queries {

    private List<NextPage> nextPage = new ArrayList<NextPage>();
    private List<Request> request = new ArrayList<Request>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<NextPage> getNextPage() {
        return nextPage;
    }

    public List<Request> getRequest() {
        return request;
    }

}