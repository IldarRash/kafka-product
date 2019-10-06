package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties
@ConditionalOnProperty(prefix= "kafka-props", name = { "host", "port", "group_id", "kafka_producer_id"})
@AutoConfigureAfter(KafkaAutoConfiguration.class)
@Import(value = {KafkaConsumerConfig.class, KafkaProducerConfig.class})
public class KafkaConfiguration {

}