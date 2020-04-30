package org.paranora.sms.service;

import com.alibaba.fastjson.JSON;
import org.paranora.sms.entity.Message;

public abstract class MessageConverterAbs<T extends Message> implements MessageConverter<T>{
    @Override
    public String toString(T message) {
        return JSON.toJSONString(message);
    }

    @Override
    public byte[] toByte(T message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T from(String message) {
        return (T)JSON.parseObject(message,getMessageType());
    }

    @Override
    public T from(byte[] message) {
        throw new UnsupportedOperationException();
    }

    protected abstract Class<T> getMessageType();
}
