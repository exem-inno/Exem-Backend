package com.backend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "sample")
public class Domain {

    @Id
    private String _id;
    private String _index;
    private String _score;
    private String _type;
    private Source _source;
}
