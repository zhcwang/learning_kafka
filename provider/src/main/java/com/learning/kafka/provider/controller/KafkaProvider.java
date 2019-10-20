package com.learning.kafka.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProvider {
    private static Logger logger = LoggerFactory.getLogger(KafkaProvider.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/kafka")
    public String testKafka() {
        int iMax = 100;
        for (int i = 1; i < iMax; i++) {
            kafkaTemplate.send("test","key" + i, "data" + i);
        }
        return "success";
    }
}
