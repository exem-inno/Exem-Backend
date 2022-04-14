package com.backend.controller;

import com.backend.controller.dto.ResponseClusterIdDto;
import com.backend.model.Domain;
import com.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DomainController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/api/cluster/{id}")
    public ResponseEntity getCluster(@PathVariable String id) {
        Domain list = productRepository.findBy_id(id);
        return ResponseEntity.ok().body(ResponseClusterIdDto.of(list.get_source().getCluster()));
    }
}
