package com.backend.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Source {
    private String cluster;
    private String namespace;
    private String service;
    private String node;
    private String pod;
    private String version;
    private String ip;
    private String traceId;
    private String spanId;
    private String parentSpanId;
    private String protocolType;
    private Long startTime;
    private int duration;
    private Long endTime;
    private String spanKind;
    private String component;
    private boolean error;
    private String dbInstance;
    private String dbStatement;
    private String dbType;
    private String dbUser;
    private String operation;
    private String peerAddress;
    private String peerHostname;
    private String peerIpv4;
    private String peerIpv6;
    private int peerPort;
    private String peerService;
    private int samplingPriority;
    private int httpStatusCode;
    private String httpUrl;
    private String httpMethod;
    private String httpApi;
    private String messagebusDestination;
    private ArrayList<Log> logs;
}
