package com.example.demokafka.controller;

import com.example.demokafka.config.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    public final Producer producer;

    @Autowired
    public TestController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
}
