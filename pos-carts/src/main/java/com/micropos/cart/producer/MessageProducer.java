package com.micropos.cart.producer;

import com.micropos.cart.channel.Source;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@EnableBinding(Source.class)
public class MessageProducer {
    @Autowired
    Source source;

    public void send(String message){
        source.output().send(MessageBuilder.withPayload(message).build());
    }

    public void sendItem(Item item){
        source.output().send(MessageBuilder.withPayload(item).build());
    }

    public void sendOrder(Order order){
        source.output().send(MessageBuilder.withPayload(order).build());
    }
}
