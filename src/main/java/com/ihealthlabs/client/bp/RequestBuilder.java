package com.ihealthlabs.client.bp;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestBuilder {

    private String uri;
    private Map<String, String> params;

    public RequestBuilder(String uri) {
        this.uri = uri;
        params = new HashMap<>();
    }

    public RequestBuilder withParam(String name, String value) {
        checkName(name);
        params.put(name, value);
        return this;
    }

    public RequestBuilder withParam(String name, long value)
    {
        checkName(name);
        params.put(name, String.valueOf(value));
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append("/?");
        sb.append(params.entrySet().stream()
                .map(k -> k.getKey() + "=" + k.getValue())
                .collect(Collectors.joining("&")));
        return sb.toString();
    }

    private void checkName(String name) {
        if (params.containsKey(name)) {
            throw new IllegalArgumentException("parameter name should be unique");
        }
    }
}
