package com.backend.controller;

import com.backend.controller.dto.OAuthLoginUrlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/oauth")
public class OAuth2Controller {

    @GetMapping("/login")
    public ResponseEntity getOAuth2Login() {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost:8080")
                .path("oauth2/authorize/google")
                .build();
        return ResponseEntity.ok().body(new OAuthLoginUrlResponse(uri.toString()));
    }
}
