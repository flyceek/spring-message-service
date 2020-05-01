package org.paranora.sms.service;

import org.paranora.sms.entity.Message;

public interface MessageService<T extends Message> {
    void send(T message);
    void sendSync(T message) throws Exception;
    void fetch(T message) throws Exception;
}
