package com.example.filter;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by lvxiao on 2018/10/24.
 */
public class KafkaConsumerListener implements MessageListener<Integer, String> {
    @Override
    public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord) {
        System.out.println("===================get message" + integerStringConsumerRecord.value());
    }
}
