package org.paranora.sms.service;

import org.paranora.sms.entity.Message;

public interface MessageConverter<T extends Message> {
    String toString(T message);
    byte[] toByte(T message);
    T from(String message);
    T from(byte[] message);
}
