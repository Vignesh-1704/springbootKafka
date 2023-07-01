/* We have created a Rest API to send a message which in turn uses the Producer
   By Auto-wiring it so that we can use those methods and use the send Message After hitting
    The publish API with a Message */

package com.m2p.springbootKafka.controller;
import com.m2p.springbootKafka.kafka.producer.JsonKafkaProducer;
import com.m2p.springbootKafka.kafka.producer.kafkaProducer;
import com.m2p.springbootKafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private kafkaProducer producer;

    @Autowired
    private JsonKafkaProducer jsonProducer;

    //http:localhost:8081/api/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam(name = "message") String message)
    {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the Topic");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> publishJson(@RequestBody User data)
    {
        jsonProducer.sendMessage(data);
        return ResponseEntity.ok("Json Message Sent to the Topic");
    }
}
