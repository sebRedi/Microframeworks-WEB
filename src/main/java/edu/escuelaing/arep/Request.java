package edu.escuelaing.arep;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private Map<String, String> queryParams = new HashMap<>();

    public Request(String queryString) {

        if(queryString == null) return;

        String[] params = queryString.split("&");

        for(String p : params) {
            String[] pair = p.split("=");

            if(pair.length == 2) {
                queryParams.put(pair[0], pair[1]);
            }
        }
    }

    public String getValues(String key) {
        return queryParams.get(key);
    }
}