package com.course.rabbitmqtwo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmqtwo.entity.InvoiceCreatedMessage;
import com.course.rabbitmqtwo.entity.InvoicePaidMessage;

@Service
public class InvoiceProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	private static final String EXCHANGE = "x.invoice";
	
	public void sendInvoiceCreated(InvoiceCreatedMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, "", message);
	}
	
	public void sendInvoicePaid(InvoicePaidMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, "", message);
	}
}
