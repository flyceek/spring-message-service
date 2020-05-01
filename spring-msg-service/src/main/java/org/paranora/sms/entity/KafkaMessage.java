package org.paranora.sms.entity;

import java.io.Serializable;

public abstract class KafkaMessage extends Message implements Serializable {
    private String topic;
    private String key;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
