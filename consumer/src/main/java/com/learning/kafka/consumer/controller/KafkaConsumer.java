package com.learning.kafka.consumer.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
@Controller
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "test")
    public void consume(ConsumerRecord<?, ?> consumer) {
        logger.info("{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
    }
}
