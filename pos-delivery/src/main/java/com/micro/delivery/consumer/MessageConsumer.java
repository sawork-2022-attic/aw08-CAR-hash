package com.micro.delivery.consumer;

import com.micro.delivery.checker.Sink;
import com.micro.delivery.repository.OrderRepository;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component
@EnableBinding(Sink.class)
public class MessageConsumer {
    @Autowired
    Sink sink;

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(Sink.INPUT)
    private void receive(String message){
        System.out.println(message);
    }

    @StreamListener(Sink.INPUT)
    private void receiveItem(Item item){
        System.out.println(item);
    }

    @StreamListener(Sink.INPUT)
    private void receiveOrder(Order order){
        System.out.println(order);
        orderRepository.save(order);
    }
}
