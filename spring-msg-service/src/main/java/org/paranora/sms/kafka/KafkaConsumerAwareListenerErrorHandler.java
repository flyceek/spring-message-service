package org.paranora.sms.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

public class KafkaConsumerAwareListenerErrorHandler implements ConsumerAwareListenerErrorHandler {
    private static final Logger log= LoggerFactory.getLogger(KafkaConsumerAwareListenerErrorHandler.class);

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        log.info("consumerAwareErrorHandler receive : "+message.getPayload().toString());
        return null;
    }
}
