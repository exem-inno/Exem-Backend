package com.backend.controller.dto;

import lombok.Data;

@Data
public class OAuthLoginUrlResponse {

    private String url;

    public OAuthLoginUrlResponse(String url) {
        this.url = url;
    }
}
