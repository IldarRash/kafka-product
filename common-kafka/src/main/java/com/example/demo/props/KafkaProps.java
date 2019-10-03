package com.example.demo.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka-props")
public class KafkaProps {
  private String server;
  private String groupId;
  private String kafkaProducerId;

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getKafkaProducerId() {
    return kafkaProducerId;
  }

  public void setKafkaProducerId(String kafkaProducerId) {
    this.kafkaProducerId = kafkaProducerId;
  }
}
