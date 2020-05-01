package org.paranora.sms.service;

import org.paranora.sms.entity.Message;

public interface MessageDeserializer<TT extends Message, TO extends Object> {
    TT deserialize(TO message);
}
