package com.example.demo.config;

import com.example.demo.dto.ProductDto;
import com.example.demo.props.KafkaProps;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerConfig {

  @Autowired
  private KafkaProps kafkaProps;

  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProps.getServer());
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProps.getKafkaProducerId());
    return props;
  }

  @Bean
  public ProducerFactory<Long, ProductDto> producerStarshipFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<Long, ProductDto> kafkaTemplate() {
    KafkaTemplate<Long, ProductDto> template = new KafkaTemplate<>(producerStarshipFactory());
    template.setMessageConverter(new StringJsonMessageConverter());
    return template;
  }

}
