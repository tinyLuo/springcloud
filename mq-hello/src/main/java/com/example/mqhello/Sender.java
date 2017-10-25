package com.example.mqhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sender {
	private static final Logger Log = LoggerFactory.getLogger(Sender.class);
	@Autowired
	private AmqpTemplate template;
	
	public void send() {
		String context = "hello world";
		Log.info("【context:{}】",context);
		template.convertAndSend("hello", context);
	}
}
