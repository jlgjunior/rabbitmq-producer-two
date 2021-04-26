package com.course.rabbitmqtwo.producer;

import java.util.stream.IntStream;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmqtwo.entity.DummyMessage;

@Service
public class MultiplePrefetchProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void simulateTransaction() {
		IntStream
			.range(0, 20000)
			.forEach(
				index ->
				{
					DummyMessage message = new DummyMessage("Transaction " + index, index);
					rabbitTemplate.convertAndSend("x.transaction", "", message);
				}
			);
	}
	
	public void simulateScheduler() {
		IntStream
			.range(0, 200)
			.forEach(
				index ->
				{
					DummyMessage message = new DummyMessage("Scheduler " + index, index);
					rabbitTemplate.convertAndSend("x.scheduler", "", message);
				}
			);
	}
}
