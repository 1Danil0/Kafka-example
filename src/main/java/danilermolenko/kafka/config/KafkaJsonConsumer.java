package danilermolenko.kafka.config;

import danilermolenko.kafka.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "studentJsonTopic", groupId = "myGroup")
    public void consume(Student student){
        LOGGER.info(String.format("Message \"%s\" received by kafka Json consumer", student));
    }
}
