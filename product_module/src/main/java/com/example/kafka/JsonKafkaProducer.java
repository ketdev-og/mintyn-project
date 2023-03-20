package com.example.kafka;


import com.example.dto.MintynOrder;
import com.example.entities.order.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, MintynOrder> kafkaTemplate;

    public void sendMessage(OrderRequest data) {
        LOG.info(String.format("message from producer json sent as %s",data.toString()));
        Message<OrderRequest> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "ODS")
                .build();
        kafkaTemplate.send(message);
    }
}
