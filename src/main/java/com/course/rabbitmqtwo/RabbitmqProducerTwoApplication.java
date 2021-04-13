package com.course.rabbitmqtwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmqtwo.entity.DummyMessage;
import com.course.rabbitmqtwo.producer.DummyProducer;

@SpringBootApplication
public class RabbitmqProducerTwoApplication implements CommandLineRunner{

	@Autowired
	private DummyProducer dummyProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerTwoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DummyMessage dummyMessage = new DummyMessage("this is a test", 1);
		dummyProducer.sendDummy(dummyMessage);
	}

}
