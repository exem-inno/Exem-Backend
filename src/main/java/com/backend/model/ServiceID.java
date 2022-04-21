package com.backend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;

@Data
@Document(collection = "service_collection")
public class ServiceID {

    @Id
    String _id;
    ArrayList service_id;
}
