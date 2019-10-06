package com.example.demo.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-props")
public class KafkaProps {
  private String host;
  private String port;
  private String groupId;
  private String kafkaProducerId;
}
