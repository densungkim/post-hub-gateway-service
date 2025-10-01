package com.post.hub.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GateWayResponse<T extends Serializable> implements Serializable {
    private String message;
    private T payload;
    private boolean success;

    public static <T extends Serializable> GateWayResponse<T> createFailed(String message) {
        return new GateWayResponse<>(message, null, false);
    }

    @Override
    public String toString() {
        return "IamResponse{" +
                "Success=" + success +
                ", message='" + message + '\'' +
                ", body='" + payload + '\'' +
                '}';
    }

    public boolean isFailed() {
        return !success;
    }

}
