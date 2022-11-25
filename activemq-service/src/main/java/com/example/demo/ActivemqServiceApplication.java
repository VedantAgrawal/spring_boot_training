package com.example.demo;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableJms
public class ActivemqServiceApplication {

	private static final String TEST_TOPIC = "test-topic";
	private static final String TEST_GROUP = "test-group";

	public static void main(String[] args) {
		SpringApplication.run(ActivemqServiceApplication.class, args);
	}

	@Bean
	public Queue activeMQQueue() {
		return new ActiveMQQueue("sample.queue");
	}
	
	@KafkaListener(topics = TEST_TOPIC, groupId = TEST_GROUP)
    public void listener1(String message) {
        System.out.println("Message: '" + message + "' from listener1");
    }
	/*
	@Bean
	public Queue kafkaQueue() {
		return new KafkaQueue("sample.queue");
	}
	
	@Bean
	public Queue rabbitMQQueue() {
		return new RabbitMQQueue("sample.queue");
	}*/
}
