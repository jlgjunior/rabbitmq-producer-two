package com.course.rabbitmqtwo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmqtwo.producer.MultiplePrefetchProducer;

@SpringBootApplication
public class RabbitmqProducerTwoApplication implements CommandLineRunner{

	@Autowired
	private MultiplePrefetchProducer multiplePrefetchProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerTwoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		multiplePrefetchProducer.simulateScheduler();
		multiplePrefetchProducer.simulateTransaction();
	}

}
