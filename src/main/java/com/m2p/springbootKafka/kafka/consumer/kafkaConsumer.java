/* Producer - publishes
   Consumer - subscribes using kafkaListener from spring kafka lib
   In a Application there can be multiple consume subscribers here we have 1 right now
   listening to the m2pTopic

   1.consume(m2pTopic) - Whenever the producer sends a message to this Topic
     The Subscriber consume method listens to this topic  */

package com.m2p.springbootKafka.kafka.consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaConsumer.class);

    // Let's create a subscriber method which will subscribe to the Topic and Logger prints the message in Topic
    @KafkaListener(topics = "m2pTopic",groupId = "myGroup")
    public void consume(String message)
    {
        LOGGER.info(String.format("Message Received -> %s",message));
    }
}
