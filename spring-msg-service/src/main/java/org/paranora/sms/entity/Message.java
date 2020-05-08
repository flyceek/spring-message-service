package org.paranora.sms.entity;

import java.io.Serializable;

public abstract class Message implements Serializable {
    protected String senderId;
    protected String[] receiverIds;
    protected String content;
    protected long time;

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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
