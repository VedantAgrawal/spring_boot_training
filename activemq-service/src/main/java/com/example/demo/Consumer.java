package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	public Consumer() {
		// TODO Auto-generated constructor stub
	}

	@JmsListener(destination="sample.queue")
	public void recieveQueue(String text) {
		System.out.println(text);
	}
}
