package org.paranora.sms.service;

import org.paranora.sms.entity.Message;

public interface MessageSerializer<TO extends Message,TT extends Object> {
    TT serialize(TO message);
}
