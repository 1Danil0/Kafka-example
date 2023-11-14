package danilermolenko.kafka.controller;

import danilermolenko.kafka.config.KafkaJsonProducer;
import danilermolenko.kafka.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class JsonMessageController {

    private KafkaJsonProducer kafkaJsonProducer;
    @Autowired
    public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Student student){
        kafkaJsonProducer.sentMessage(student);
        return ResponseEntity.ok("JSON Student was sent");
    }
}
