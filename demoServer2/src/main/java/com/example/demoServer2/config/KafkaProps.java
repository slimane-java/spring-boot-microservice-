package com.example.demoServer2.config;

import com.example.demoServer2.dto.KafkaDto;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Configuration
@ConfigurationProperties(prefix = "demo.kafka")
public class KafkaProps {
    private String topic;
}
