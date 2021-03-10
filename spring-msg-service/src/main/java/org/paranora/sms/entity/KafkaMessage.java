package org.paranora.sms.entity;

public abstract class KafkaMessage extends Message {
    protected String topic;
    protected Integer partition;
    protected String key;

    public KafkaMessage(){
        partition=0;
    }

    public Integer getPartition() {
        return partition;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }

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
