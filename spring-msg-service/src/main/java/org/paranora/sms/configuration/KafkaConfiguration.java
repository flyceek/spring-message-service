package org.paranora.sms.configuration;

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
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.support.ProducerListener;

@Configuration
@EnableKafka
@EnableConfigurationProperties(KafkaProperties.class)
@Profile({"kafka"})
public class KafkaConfiguration {

    @Autowired
    private KafkaProperties properties;

    @Bean
    public ConsumerAwareListenerErrorHandler kafkaConsumerAwareListenerErrorHandler() {
        return new KafkaConsumerAwareListenerErrorHandler();
    }

    @Configuration
    @Profile({"kafka-producer"})
    public class KafkaProducerConfiguration {

        @Bean
        public ProducerListener producerListener() {
            return new KafkaProducerResultHandler();
        }

        @Configuration
        public class KafkaRongYunPrivateMessageProducerConfiguration extends KafkaRongYunPrivateMessageConfigurationFactory {

            @Bean
            public KafkaTemplate<String, RongYunPrivateKafkaMessage> rongYunPrivateMessageKafkaTemplate() {
                return createKafkaTemplate(properties.buildProducerProperties());
            }
        }

        @Configuration
        public class KafkaRongYunGroupMessageProducerConfiguration extends KafkaRongYunGroupMessageConfigurationFactory {

            @Bean
            public KafkaTemplate<String, RongYunGroupKafkaMessage> rongYunGroupMessageKafkaTemplate() {
                return createKafkaTemplate(properties.buildProducerProperties());
            }
        }

        @Configuration
        public class KafkaRongYunSystemMessageProducerConfiguration extends KafkaRongYunSystemMessageConfigurationFactory {

            @Bean
            public KafkaTemplate<String, RongYunSystemKafkaMessage> rongYunSystemMessageKafkaTemplate() {
                return createKafkaTemplate(properties.buildProducerProperties());
            }
        }
    }

    @Configuration
    @Profile({"kafka-consumer"})
    public class KafkaConsumerConfiguration {

        @Configuration
        @Profile({"kafka-rongyun-private-message-consumer"})
        public class KafkaRongYunPrivateMessageConsumerConfiguration extends KafkaRongYunPrivateMessageConfigurationFactory{

            @Bean
            public ConcurrentKafkaListenerContainerFactory<String, RongYunPrivateKafkaMessage> kafkaListenerContainerFactory() {
                return createKafkaListenerContainerFactory(properties.buildConsumerProperties());
            }
        }

        @Configuration
        @Profile({"kafka-rongyun-group-message-consumer"})
        public class KafkaRongYunGroupMessageConsumerConfiguration extends KafkaRongYunGroupMessageConfigurationFactory{

            @Bean
            public ConcurrentKafkaListenerContainerFactory<String, RongYunGroupKafkaMessage> kafkaListenerContainerFactory() {
                return createKafkaListenerContainerFactory(properties.buildConsumerProperties());
            }
        }

        @Configuration
        @Profile({"kafka-rongyun-system-message-consumer"})
        public class KafkaRongYunSystemMessageConsumerConfiguration extends KafkaRongYunSystemMessageConfigurationFactory{

            @Bean
            public ConcurrentKafkaListenerContainerFactory<String, RongYunSystemKafkaMessage> kafkaListenerContainerFactory() {
                return createKafkaListenerContainerFactory(properties.buildConsumerProperties());
            }
        }

    }

}
