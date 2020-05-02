package org.paranora.sms.kafka;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.ProducerListener;

import java.util.Map;

public interface KafkaConfigurationFactory<TK extends Object,TV extends Object> {
    KafkaTemplate<TK, TV> createKafkaTemplate(Map<String, Object> properties);
    ProducerListener createProducerListener();
    ProducerFactory<TK, TV> createProducerFactory(Map<String, Object> properties);
    ConsumerFactory<TK, TV> createConsumerFactory(Map<String, Object> properties);
    ConcurrentKafkaListenerContainerFactory<TK, TV> createKafkaListenerContainerFactory(Map<String, Object> properties);
    MessageListener<TK,TV> createMessageListener(String clientId, String groupId, String topic);
    Class<TV> getValueClass();
}
