package com.backend.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Log {
    private Long timestamp;
    private ArrayList<Fields> fields;
}
