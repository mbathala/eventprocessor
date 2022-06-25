package com.wf.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wf.kafka.dao.SportsRepo;
import com.wf.kafka.model.Tutorial;
import com.wf.kafka.service.SportsService;

@Service
public class SpringBootKafkaConsumer {

	@Autowired
	SportsService sportsService;
	
    @KafkaListener(topics = "${topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Tutorial value){
    	System.out.println("In Kafka listnere >>>>");
        System.out.println("Message Received :: "+value.toString());
        
        sportsService.saveData(value);
    }
}
