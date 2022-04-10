package com.backend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collation = "board")
public class Board {

    @Id
    private String _id;
    private String title;
    private String content;
}
