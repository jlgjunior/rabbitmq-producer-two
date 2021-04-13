package com.course.rabbitmqtwo;

import java.util.stream.IntStream;

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
		IntStream
			.range(0, 10000)
			.forEach(
					index -> {
						DummyMessage dummyMessage = new DummyMessage("this is a test", index);
						dummyProducer.sendDummy(dummyMessage);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			);
	}

}
