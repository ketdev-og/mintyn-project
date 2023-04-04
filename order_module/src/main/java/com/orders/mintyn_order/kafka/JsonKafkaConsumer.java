package com.orders.mintyn_order.kafka;


import com.orders.mintyn_order.dto.MintynOrder;
import com.orders.mintyn_order.entities.order.OrderRequest;
import com.orders.mintyn_order.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @Autowired
    OrderService orderService;
    private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaConsumer.class);


    @KafkaListener(topics = "ODS", groupId = "ODR",
            topicPartitions =
                    {@TopicPartition(topic = "ODS",
                            partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0")),

                    }
    )
    public OrderRequest consumer(OrderRequest message) {
        MintynOrder order = orderService.createOrder(message);
        LOG.info(String.format("message from consumer json retrieves %s", message.toString()));
        LOG.info(String.format("sent to database %s", order.toString()));
        return message;
    }
}
