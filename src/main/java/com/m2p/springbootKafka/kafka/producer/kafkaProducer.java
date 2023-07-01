/* Lets create a Kafka Producer to write a Message to the Kafka server / broker
Inorder to send message to Topic we are going to use spring provided Kafka Template which is Auto-Configured
 So All we must do is just Inject the Kafka template here */

/* Here we use the spring boot provided default logger to log the messages*/

package com.m2p.springbootKafka.kafka.producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {
    private KafkaTemplate<String,String> kafkaTemplate;

    //Creating a Logger Instance
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    //Constructor Injection
    public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Method which will use kafka template to send messages
    public void sendMessage(String message)
    {
        LOGGER.info(String.format("Message sent: %s",message));
        kafkaTemplate.send("m2pTopic",message);
    }
}
