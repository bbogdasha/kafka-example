package com.bogdan.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * First step is to start Zookeeper & Kafka server in kafka folder:
 * cmd_1: .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 * cmd_2: .\bin\windows\kafka-server-start.bat .\config\server.properties
 * cmd_3: bin/kafka-console-consumer.sh --topic bogdan --from-beginning --bootstrap-server localhost:9092
 */

@SpringBootApplication
public class KafkaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				kafkaTemplate.send("bogdan", "Hello world " + i + " !");
			}
		};
	}

}
