package com.backend.repository;

import com.backend.model.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface ProductRepository extends MongoRepository<Domain, String> {
    Domain findBy_id(String id);
    ArrayList<Domain> findDistinctBy_sourceNotNull();
}
