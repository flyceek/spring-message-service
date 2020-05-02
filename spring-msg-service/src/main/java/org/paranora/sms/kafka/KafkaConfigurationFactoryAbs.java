package org.paranora.sms.kafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

public abstract class KafkaConfigurationFactoryAbs<TK extends Object, TV extends Object> implements KafkaConfigurationFactory<TK, TV> {
    @Override
    public KafkaTemplate<TK, TV> createKafkaTemplate(Map<String, Object> properties) {
        KafkaTemplate template = new KafkaTemplate<TK, TV>(createProducerFactory(properties));
        template.setProducerListener(createProducerListener());
        return template;
    }

    @Override
    public ProducerListener createProducerListener() {
        return new KafkaProducerResultHandler();
    }

    @Override
    public ProducerFactory<TK, TV> createProducerFactory(Map<String, Object> properties) {
        return new DefaultKafkaProducerFactory(properties);
    }

    @Override
    public ConsumerFactory<TK, TV> createConsumerFactory(Map<String, Object> properties) {
        return new DefaultKafkaConsumerFactory(
                properties,
                new StringDeserializer(),
                new JsonDeserializer<>(getValueClass()));
    }

    @Override
    public ConcurrentKafkaListenerContainerFactory<TK, TV> createKafkaListenerContainerFactory(Map<String, Object> properties) {
        ConcurrentKafkaListenerContainerFactory<TK, TV> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(createConsumerFactory(properties));
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

}
