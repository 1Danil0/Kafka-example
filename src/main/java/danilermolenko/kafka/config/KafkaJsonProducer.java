package danilermolenko.kafka.config;

import danilermolenko.kafka.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, Student> kafkaTemplate;
    @Autowired
    public KafkaJsonProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sentMessage(Student student){

        LOGGER.info(String.format("KafkaJsonProducer sent message: \"%s\"", student.toString()));

        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "danilsTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
