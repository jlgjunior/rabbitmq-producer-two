package com.course.rabbitmqtwo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmqtwo.entity.DummyMessage;

@Service
public class DummyProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendDummy(DummyMessage message) {
		rabbitTemplate.convertAndSend("x.dummy", "", message);
	}
}
