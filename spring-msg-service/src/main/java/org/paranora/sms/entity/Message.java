package org.paranora.sms.entity;

import java.io.Serializable;

public abstract class Message implements Serializable {
    private String senderId;
    private String[] receiverIds;
    private String content;
    private String time;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String[] getReceiverIds() {
        return receiverIds;
    }

    public void setReceiverIds(String[] receiverIds) {
        this.receiverIds = receiverIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
