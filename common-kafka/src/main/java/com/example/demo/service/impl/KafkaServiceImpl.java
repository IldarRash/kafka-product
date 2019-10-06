package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.KafkaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    private final Logger log = LoggerFactory.getLogger(KafkaServiceImpl.class);

    private final KafkaTemplate<Long, ProductDto> kafkaTemplate;
    private final ObjectMapper objectMapper;


    public KafkaServiceImpl(KafkaTemplate<Long, ProductDto> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }


    @Override
    public ProductDto save(ProductDto dto) {
        return null;
    }

    @Override
    public void send(ProductDto dto) {
        log.info("<= sending {}", writeValueAsString(dto));
        kafkaTemplate.send("server.product", dto);
    }

    @Override
    @KafkaListener(id = "Product", topics = {"server.product"}, containerFactory = "singleFactory")
    public void consume(ProductDto dto) {
        log.info("Get message {}", writeValueAsString(dto));
    }


    @SneakyThrows
    private String writeValueAsString(ProductDto dto) {
        return objectMapper.writeValueAsString(dto);

    }
}
