package com.m2p.springbootKafka.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicConfig {

    //A Bean to create a Topic
    @Bean
    public NewTopic m2pTopic(){
        //We can mention the partitions too for now we are using the default partitions
        return TopicBuilder.name("m2pTopic")
                .build();
    }
}
