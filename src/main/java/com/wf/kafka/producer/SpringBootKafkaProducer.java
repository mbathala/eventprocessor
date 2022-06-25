package com.wf.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.wf.kafka.model.Tutorial;

@Service
public class SpringBootKafkaProducer {

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaTemplate<String, Tutorial> tutorialKafkaTemplate;

    public void sendMessage(String value) {
    	Tutorial tutorial = new Tutorial();
    	tutorial.setLocation(value);
        ListenableFuture<SendResult<String,Tutorial>> future = tutorialKafkaTemplate.send("test-topic", tutorial);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Messages failed to push on topic");
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println("Messages successfully pushed on topic");
            }
        });
    }

    public void sendMessage(Tutorial value) {
        ListenableFuture<SendResult<String,Tutorial>> future = tutorialKafkaTemplate.send("test-topic", value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Messages failed to push on topic");
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println("Messages successfully pushed on topic");
            }
        });
    }



}
