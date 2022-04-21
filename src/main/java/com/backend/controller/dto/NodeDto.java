package com.backend.controller.dto;

import lombok.Data;

@Data
public class NodeDto {
    String node;
    int pod_count;

    public NodeDto(String node, int pod_count) {
        this.node = node;
        this.pod_count = pod_count;
    }
}
