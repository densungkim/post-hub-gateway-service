package com.post.hub.gateway.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GateWayRequest<T extends Serializable> implements Serializable {
    private String path;
    private String httpMethod;
    private T payload;

    public GateWayRequest(String path, String httpMethod, T payload) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.payload = payload;
    }

    public static <T extends Serializable> GateWayRequest<T> create(String path, String httpMethod, T payload) {
        return new GateWayRequest<>(path, httpMethod, payload);
    }

}
