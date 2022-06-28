package com.wf.kafka.model;

import org.springframework.data.annotation.Id;

public class Tutorial {

    String topicName;
    String publisher;
    String location;
    String opType;
    @Id
    String topicId;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "topicName='" + topicName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", location='" + location + '\'' +
                ", opType='" + opType + '\'' +
                ", topicId='" + topicId + '\'' +
                '}';
    }
}
