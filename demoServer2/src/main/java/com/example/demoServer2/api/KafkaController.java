package com.example.demoServer2.api;

import com.example.demoServer2.kafka.MessageProducer;
import com.example.demoServer2.kafka.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

    private final MessageProducer messageProducer;
    private final MessageRepository messageRepository;

    @GetMapping("/send")
    public String sendMsg(
            @RequestParam("msg") String message) {
        messageProducer.sendMessage(message);
        return "" +"'+message +'" + " sent successfully!";
    }

    //Read all messages
    @GetMapping("/getAll")
    public List<String> getAllMessages() {
        return messageRepository.getAllMessages() ;
    }
}
