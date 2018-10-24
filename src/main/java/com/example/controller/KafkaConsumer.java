package com.example.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvxiao on 2018/10/24.
 */
@RestController
public class KafkaConsumer  implements MessageListener<Integer, String> {

    @RequestMapping("/kafka")
    @Override
    public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord) {
        System.out.println(integerStringConsumerRecord.value());
    }
}
