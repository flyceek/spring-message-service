package org.paranora.sms.service;

import org.paranora.sms.entity.Message;

public interface MessageFetcher<T extends Message> {
    boolean fetch(T message) throws Exception;
}
