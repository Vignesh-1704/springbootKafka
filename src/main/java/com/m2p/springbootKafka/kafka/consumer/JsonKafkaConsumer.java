package com.m2p.springbootKafka.kafka.consumer;

import com.m2p.springbootKafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "m2pJsonTopic",groupId = "MyGroup")
    public void consumeJson(User data)
    {
        LOGGER.info(String.format("Message Received -> %s",data.toString()));
    }
}
