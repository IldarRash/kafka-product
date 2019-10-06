package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VkClientService {

  private final KafkaService service;

  @PostConstruct
  public void init() {
    for(int i = 0; i < 10; i++) {
      ProductDto productDto = new ProductDto((long) i, LocalDateTime.now(), LocalDateTime.now(), "name i");
      service.send(productDto);
    }
  }
}
