package org.paranora.sms.entity;

public class RongYunGroupKafkaMessage extends RongYunKafkaMessage {
    private String groupId;

    public RongYunGroupKafkaMessage() {
        this.topic="paranora-rongyun-group-message";
        this.key="rongyun-group-msg";
        this.partition=0;
        this.channelType="GROUP";
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
