package org.paranora.sms.service;

import org.paranora.sms.entity.KafkaMessage;

public abstract class KafkaMessageConverterAbs<T extends KafkaMessage> extends MessageConverterAbs<T> {
}
