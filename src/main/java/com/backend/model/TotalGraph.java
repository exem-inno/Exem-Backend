package com.backend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "totalApi2")
public class TotalGraph {

    @Id
    String id;

    Long startTime;
    String peerAddress;
    int peerPort;
    String httpMethod;
    String httpApi;
    int httpStatusCode;
    int duration;
    String service;
    String pod;
}
