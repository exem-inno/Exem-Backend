package com.backend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "fromto")
public class FromTo {

    @Id
    String _id;
    String from;
    String to;
}
