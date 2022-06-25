package com.wf.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wf.kafka.consumer.SpringBootKafkaConsumer;
import com.wf.kafka.model.Tutorial;
import com.wf.kafka.producer.SpringBootKafkaProducer;

@RestController
public class SpringBootKafkaRestController {

    @Autowired
    SpringBootKafkaProducer springBootKafkaProducer;
    
    @Autowired
    SpringBootKafkaConsumer springBootKafkaConsumer;

    @GetMapping(value = "/send/{message}")
    public void send(@PathVariable String message) {
        springBootKafkaProducer.sendMessage(message);
    }

    @PostMapping(value = "/sendJson")
    public void send(@RequestBody Tutorial tutorial) {
    	long lStartTime = System.currentTimeMillis();
    	
    	springBootKafkaProducer.sendMessage(tutorial);
    	
    	long lEndTime = System.currentTimeMillis();

        long output = lEndTime - lStartTime;

        System.out.println("Message processing time in milliseconds :: " + output);
    }

}
