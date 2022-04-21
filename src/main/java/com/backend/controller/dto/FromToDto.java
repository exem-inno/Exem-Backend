package com.backend.controller.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class FromToDto {

    String from;
    String to;
    int count;

    public FromToDto(String from, String to, int count) {
        this.from = from;
        this.to = to;
        this.count = count;
    }

    public void plusCount() {
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FromToDto)) return false;
        FromToDto fromToDto = (FromToDto) o;
        return (from == fromToDto.from && to ==fromToDto.to);
    }

}
