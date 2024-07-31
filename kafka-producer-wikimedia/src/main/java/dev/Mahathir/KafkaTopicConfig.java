package dev.Mahathir;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaTopicConfig {
    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name("wikimedia_recentchange")
                .build();
    }
}
