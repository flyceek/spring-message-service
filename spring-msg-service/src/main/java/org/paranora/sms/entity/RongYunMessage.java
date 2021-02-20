package org.paranora.sms.entity;

import io.rong.messages.BaseMessage;

public class RongYunMessage extends BaseMessage {

    private String objectName;
    private String content;

    public RongYunMessage(String objectName,String content){
        this.objectName=objectName;
        this.content=content;
    }

    @Override
    public String getType() {
        return objectName;
    }

    @Override
    public String toString() {
        return content;
    }
}
