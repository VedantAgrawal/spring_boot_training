package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {
/*
	public KafkaProducer() {
		// TODO Auto-generated constructor stub
	}
*/	
	private static final String TEST_TOPIC = "test-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;
/*
    public MessageProducerController(@Qualifier("kafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send-message")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send(TEST_TOPIC, messageRequest.message());
    }
*/
}
