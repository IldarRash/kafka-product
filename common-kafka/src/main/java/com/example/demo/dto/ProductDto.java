package com.example.demo.dto;

import java.time.LocalDateTime;

public class ProductDto extends AbstractDto {

    private String name;

    public ProductDto(Long id, LocalDateTime created, LocalDateTime updated, String name) {
        super(id, created, updated);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
