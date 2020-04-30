package org.paranora.sms.entity;

public class KafkaMessage extends Message{
    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
