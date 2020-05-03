package org.paranora.sms.entity;

public class RongYunGroupKafkaMessage extends RongYunKafkaMessage {
    private String groupId;

    public RongYunGroupKafkaMessage() {
        this.channelType="GROUP";
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
