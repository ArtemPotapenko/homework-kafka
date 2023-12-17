package com.example.kafaconsumer.configurations;

import com.example.kafaconsumer.services.Consumer;
import lombok.val;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfiguration {
    @Bean
    public ConsumerFactory<String,String> ConsumerFactory(){
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:8081");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"default");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(properties);}
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(ConsumerFactory<String,String> factory){
        ConcurrentKafkaListenerContainerFactory<String, String> stringStringConcurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        stringStringConcurrentKafkaListenerContainerFactory.setConsumerFactory(factory);
        return stringStringConcurrentKafkaListenerContainerFactory;
    }
}
