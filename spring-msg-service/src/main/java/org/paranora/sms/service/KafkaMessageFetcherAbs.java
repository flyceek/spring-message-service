package org.paranora.sms.service;

import org.paranora.sms.entity.KafkaMessage;

public abstract class KafkaMessageFetcherAbs<T extends KafkaMessage> implements MessageFetcher<T> {

}
