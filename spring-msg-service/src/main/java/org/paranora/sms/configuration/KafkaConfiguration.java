package org.paranora.sms.configuration;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.paranora.sms.kafka.KafkaProducerResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.kafka.support.serializer.JsonDeserializer;

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
    public class KafkaRongYunPrivateMessageProducerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public KafkaTemplate<String, RongYunPrivateKafkaMessage> kafkaTemplate() {
            KafkaTemplate template = new KafkaTemplate<String, RongYunPrivateKafkaMessage>(producerFactory());
            template.setProducerListener(producerListener());
            return template;
        }

        @Bean
        public ProducerListener producerListener() {
            return new KafkaProducerResultHandler();
        }

        @Bean
        public ProducerFactory<String, RongYunPrivateKafkaMessage> producerFactory() {
            return new DefaultKafkaProducerFactory(properties.buildProducerProperties());
        }
    }


    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-group-message-producer"})
    public class KafkaRongYunGroupMessageProducerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public KafkaTemplate<String, RongYunGroupKafkaMessage> kafkaTemplate() {
            KafkaTemplate template = new KafkaTemplate<String, RongYunGroupKafkaMessage>(producerFactory());
            template.setProducerListener(producerListener());
            return template;
        }

        @Bean
        public ProducerListener producerListener() {
            return new KafkaProducerResultHandler();
        }

        @Bean
        public ProducerFactory<String, RongYunGroupKafkaMessage> producerFactory() {
            return new DefaultKafkaProducerFactory(properties.buildProducerProperties());
        }
    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-system-message-producer"})
    public class KafkaRongYunSystemMessageProducerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public KafkaTemplate<String, RongYunSystemKafkaMessage> kafkaTemplate() {
            KafkaTemplate template = new KafkaTemplate<String, RongYunSystemKafkaMessage>(producerFactory());
            template.setProducerListener(producerListener());
            return template;
        }

        @Bean
        public ProducerListener producerListener() {
            return new KafkaProducerResultHandler();
        }

        @Bean
        public ProducerFactory<String, RongYunSystemKafkaMessage> producerFactory() {
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

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-private-message-consumer"})
    public class KafkaRongYunPrivateMessageConsumerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public ConsumerFactory<String, RongYunPrivateKafkaMessage> consumerFactory() {
            return new DefaultKafkaConsumerFactory<>(
                    properties.buildConsumerProperties(),
                    new StringDeserializer(),
                    new JsonDeserializer<>(RongYunPrivateKafkaMessage.class));
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, RongYunPrivateKafkaMessage> kafkaListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, RongYunPrivateKafkaMessage> factory =
                    new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }
    }

    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-private-message-consumer"})
    public class KafkaRongYunGroupMessageConsumerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public ConsumerFactory<String, RongYunGroupKafkaMessage> consumerFactory() {
            return new DefaultKafkaConsumerFactory<>(
                    properties.buildConsumerProperties(),
                    new StringDeserializer(),
                    new JsonDeserializer<>(RongYunGroupKafkaMessage.class));
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, RongYunGroupKafkaMessage> kafkaListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, RongYunGroupKafkaMessage> factory =
                    new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }
    }


    @Configuration
    @EnableKafka
    @EnableConfigurationProperties(KafkaProperties.class)
    @Profile({"kafka-rongyun-system-message-consumer"})
    public class KafkaRongYunSystemMessageConsumerConfiguration {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public ConsumerFactory<String, RongYunSystemKafkaMessage> consumerFactory() {
            return new DefaultKafkaConsumerFactory<>(
                    properties.buildConsumerProperties(),
                    new StringDeserializer(),
                    new JsonDeserializer<>(RongYunPrivateKafkaMessage.class));
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, RongYunSystemKafkaMessage> kafkaListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, RongYunSystemKafkaMessage> factory =
                    new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }
    }
}
