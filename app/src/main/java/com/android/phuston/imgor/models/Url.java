package com.android.phuston.imgor.models;

import java.util.HashMap;
import java.util.Map;

public class Url {

    private String type;
    private String template;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
        return type;
    }

    public String getTemplate() {
        return template;
    }

}