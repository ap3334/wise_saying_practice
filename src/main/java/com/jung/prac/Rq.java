package com.jung.prac;

import java.util.HashMap;
import java.util.Map;

public class Rq {

    private String query;
    private String path;
    private Map<String, String> queryParam = new HashMap<>();

    public Rq(String query) {
        this.query = query;

        String[] bits = this.query.split("\\?", 2);
        this.path = bits[0];

        if (bits.length == 2) {

            String[] queryBits = bits[1].split("&");

            for (String queryBit : queryBits) {
                String[] queryParamBits = queryBit.split("=", 2);

                if (queryParamBits.length == 1) continue;

                String queryName = queryParamBits[0];
                String queryValue = queryParamBits[1];

                queryParam.put(queryName, queryValue);
            }
        }

    }

    public String getQuery() {
        return query;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getQueryParam() {
        return queryParam;
    }

    public String getQueryParam(String s, String defaultValue) {

        if (queryParam.containsKey(s)) {
            return queryParam.get(s);
        }

        return defaultValue;
    }
}
