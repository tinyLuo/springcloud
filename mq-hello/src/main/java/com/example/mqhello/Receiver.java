package com.example.mqhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues="hello")
public class Receiver {
	private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
	@RabbitHandler
	public void consumer(String receive) {
		LOG.info("Receiver:{}",receive);
	}
}
