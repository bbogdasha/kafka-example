package com.bogdan.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Listener class for outputting and interacting with data.
 */

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "bogdan",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("Data received: " + data + " :)");
    }
}
