package org.paranora.smp.configuration;

import org.paranora.smp.kafka.KafkaSendResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;

@Configuration
@EnableKafka
@EnableConfigurationProperties(KafkaProperties.class)
@Profile("kafka")
public class KafkaConfiguration {

    @Autowired
    private KafkaProperties properties;

    @Bean
    public KafkaTemplate<Integer,String> kafkaTemplate() {
        KafkaTemplate template = new KafkaTemplate<Integer, String>(producerFactory());
        template.setProducerListener(producerListener());
        return template;
    }

    @Bean
    public ProducerListener producerListener(){
        return new KafkaSendResultHandler();
    }

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory(properties.buildProducerProperties());
    }
}
