package com.post.hub.gateway.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GateWayRequiredBodyField implements Serializable {
    private Integer userId;
}
