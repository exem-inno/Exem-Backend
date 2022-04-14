package com.backend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Optional;

@Data
@Document(collection = "testdb")
public class Domain {

    @Id
    private String _id;
    private String _index;
    private String _score;
    private String _type;
    private Source _source;
}
