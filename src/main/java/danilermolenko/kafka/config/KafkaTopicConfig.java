package danilermolenko.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic stringTopic(){
        return TopicBuilder.name("danilsTopic").build();
    }
    @Bean
    public NewTopic studentJsonTopic(){
        return TopicBuilder.name("studentJsonTopic").build();
    }

}
