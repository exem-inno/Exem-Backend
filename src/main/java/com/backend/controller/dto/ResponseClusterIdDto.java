package com.backend.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResponseClusterIdDto {
    private String result;

    public ResponseClusterIdDto(String result) {
        this.result = result;
    }

    public static ResponseClusterIdDto of(String result) {
        return new ResponseClusterIdDto(result);
    }

}
