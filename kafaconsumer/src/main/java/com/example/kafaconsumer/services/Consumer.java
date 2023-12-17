package com.example.kafaconsumer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Consumer {
   @KafkaListener(topics = "my.name")
    public void listen(String msg){
       System.out.println(msg);
   }

}
