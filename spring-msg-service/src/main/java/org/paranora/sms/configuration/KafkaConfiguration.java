package org.paranora.sms.configuration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.paranora.sms.kafka.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.ProducerListener;

@Configuration
@Profile({"kafka"})
public class KafkaConfiguration {

    @Autowired
    private KafkaProperties properties;

    @Bean
    public ConsumerAwareListenerErrorHandler kafkaConsumerAwareListenerErrorHandler() {
        return new KafkaConsumerAwareListenerErrorHandler();
    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-producer"})
    public class KafkaProducerConfiguration {

        @Bean
        public KafkaTemplate<Integer, String> kafkaTemplate() {
            KafkaTemplate template = new KafkaTemplate<Integer, String>(producerFactory());
            template.setProducerListener(producerListener());
            return template;
        }

        @Bean
        public ProducerListener producerListener() {
            return new KafkaProducerResultHandler();
        }

        @Bean
        public ProducerFactory<Integer, String> producerFactory() {
            return new DefaultKafkaProducerFactory(properties.buildProducerProperties());
        }
    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-private-message-producer"})
    public class KafkaRongYunPrivateMessageProducerConfiguration extends KafkaRongYunPrivateMessageConfigurationFactory {


        @Bean
        public KafkaTemplate<String, RongYunPrivateKafkaMessage> kafkaTemplate() {
            return createKafkaTemplate(properties.buildProducerProperties());
        }

        @Bean
        public ProducerListener producerListener() {
            return createProducerListener();
        }

    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-group-message-producer"})
    public class KafkaRongYunGroupMessageProducerConfiguration extends KafkaRongYunGroupMessageConfigurationFactory {

        @Bean
        public KafkaTemplate<String, RongYunGroupKafkaMessage> kafkaTemplate() {
            return createKafkaTemplate(properties.buildProducerProperties());
        }

        @Bean
        public ProducerListener producerListener() {
            return createProducerListener();
        }

    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-system-message-producer"})
    public class KafkaRongYunSystemMessageProducerConfiguration extends KafkaRongYunSystemMessageConfigurationFactory {

        @Bean
        public KafkaTemplate<String, RongYunSystemKafkaMessage> kafkaTemplate() {
            return createKafkaTemplate(properties.buildProducerProperties());
        }

        @Bean
        public ProducerListener producerListener() {
            return new KafkaProducerResultHandler();
        }

    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-consumer"})
    public class KafkaConsumerConfiguration {

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
            factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
            return factory;
        }

    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-private-message-consumer"})
    public class KafkaRongYunPrivateMessageConsumerConfiguration extends KafkaRongYunPrivateMessageConfigurationFactory{

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, RongYunPrivateKafkaMessage> kafkaListenerContainerFactory() {
            return createKafkaListenerContainerFactory(properties.buildConsumerProperties());
        }

//        @Bean
//        public KafkaMessageListenerContainer demoListenerContainer() {
//            ContainerProperties containerProperties = new ContainerProperties("topic.quick.bean");
//            containerProperties.setGroupId("bean");
//            containerProperties.setClientId("paranora");
//            containerProperties.setMessageListener(new AcknowledgingMessageListener<String,RongYunPrivateKafkaMessage>() {
//
//                @Override
//                public void onMessage(ConsumerRecord<String, RongYunPrivateKafkaMessage> data, Acknowledgment acknowledgment) {
//
//                }
//            });
//
//            return new KafkaMessageListenerContainer(createConsumerFactory(properties.buildConsumerProperties()), containerProperties);
//        }
    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-group-message-consumer"})
    public class KafkaRongYunGroupMessageConsumerConfiguration extends KafkaRongYunGroupMessageConfigurationFactory{

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, RongYunGroupKafkaMessage> kafkaListenerContainerFactory() {
            return createKafkaListenerContainerFactory(properties.buildConsumerProperties());
        }
    }


    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-system-message-consumer"})
    public class KafkaRongYunSystemMessageConsumerConfiguration extends KafkaRongYunSystemMessageConfigurationFactory{

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, RongYunSystemKafkaMessage> kafkaListenerContainerFactory() {
            return createKafkaListenerContainerFactory(properties.buildConsumerProperties());
        }
    }
}
