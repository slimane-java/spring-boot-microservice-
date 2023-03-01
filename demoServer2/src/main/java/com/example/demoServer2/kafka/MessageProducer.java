package com.example.demoServer2.kafka;

import com.example.demoServer2.config.KafkaProps;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaProps kafkaProps;

    public void sendMessage(String message) {
        log.info("MESSAGE SENT FROM PRODUCER END -> " + message);
        log.info("MESSAGE SENT FROM PRODUCER END Topic -> " + kafkaProps.getTopic());
        kafkaTemplate.send(kafkaProps.getTopic(), message);
    }
}
