package com.example.demoServer2.kafka;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageRepository {

    private List<String> list = new ArrayList<>();

    public void addMessage(String s){
        list.add(s);
    }

    public List<String> getAllMessages(){
        return this.list;
    }
}
