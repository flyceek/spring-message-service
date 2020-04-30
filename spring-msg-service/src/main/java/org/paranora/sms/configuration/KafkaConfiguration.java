package org.paranora.sms.configuration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.paranora.sms.kafka.KafkaSendResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.ProducerListener;

@Configuration
@Profile({"kafka"})
public class KafkaConfiguration {

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-producer"})
    public class KafkaProducerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public KafkaTemplate<Integer, String> kafkaTemplate() {
            KafkaTemplate template = new KafkaTemplate<Integer, String>(producerFactory());
            template.setProducerListener(producerListener());
            return template;
        }

        @Bean
        public ProducerListener producerListener() {
            return new KafkaSendResultHandler();
        }

        @Bean
        public ProducerFactory<Integer, String> producerFactory() {
            return new DefaultKafkaProducerFactory(properties.buildProducerProperties());
        }
    }


    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-consumer"})
    public class KafkaConsumerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public ConsumerFactory<Object, Object> consumerFactory() {
            return new DefaultKafkaConsumerFactory<>(properties.buildConsumerProperties());
        }

//        @Bean
//        @ConditionalOnBean(ConcurrentKafkaListenerContainerFactoryConfigurer.class)
//        public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
//            ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//            configurer.configure(factory, consumerFactory());
//            factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
//            return factory;
//        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());
            factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
            return factory;
        }

    }
}
