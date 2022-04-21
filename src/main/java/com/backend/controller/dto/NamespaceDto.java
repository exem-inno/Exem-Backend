package com.backend.controller.dto;

import lombok.Data;

@Data
public class NamespaceDto {

    String namespace;
    int node_count;
    int pod_count;

    public NamespaceDto(String namespace, int node_count, int pod_count) {
        this.namespace = namespace;
        this.node_count = node_count;
        this.pod_count = pod_count;
    }
}
