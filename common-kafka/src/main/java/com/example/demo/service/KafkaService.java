package com.example.demo.service;

import com.example.demo.dto.ProductDto;

public interface KafkaService {

    ProductDto save(ProductDto dto);

    void send(ProductDto dto);

    void consume(ProductDto dto);
}
