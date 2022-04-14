package com.backend.repository;

import com.backend.model.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Domain, String> {
    Domain findBy_id(String id);
    List<Domain> findAllBy_source_Node(String node);
}
