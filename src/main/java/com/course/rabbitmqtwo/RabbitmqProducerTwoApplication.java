package com.course.rabbitmqtwo;


import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmqtwo.entity.InvoiceCreatedMessage;
import com.course.rabbitmqtwo.entity.InvoicePaidMessage;
import com.course.rabbitmqtwo.producer.InvoiceProducer;

@SpringBootApplication
public class RabbitmqProducerTwoApplication implements CommandLineRunner{

	@Autowired
	private InvoiceProducer invoiceProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerTwoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String invoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(100, 200);
		InvoiceCreatedMessage invoiceCreatedMessage = 
						new InvoiceCreatedMessage(152.6, LocalDate.now().minusDays(2), "USD", invoiceNumber);
		invoiceProducer.sendInvoiceCreated(invoiceCreatedMessage);
		
		invoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
		String paymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(800, 1000);
		InvoicePaidMessage invoicePaidMessage = 
						new InvoicePaidMessage(invoiceNumber, LocalDate.now(), paymentNumber);
		invoiceProducer.sendInvoicePaid(invoicePaidMessage); 
	}

}
