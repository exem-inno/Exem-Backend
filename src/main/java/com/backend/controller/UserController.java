package com.backend.controller;

import com.backend.exception.ResourceNotFoundException;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import com.backend.security.CurrentUser;
import com.backend.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return ResponseEntity.ok().body(userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId())));
    }
}