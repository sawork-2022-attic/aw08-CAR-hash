package com.micro.delivery.service;

import com.micro.delivery.repository.OrderRepository;
import com.micropos.datatype.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

public class DeliveryService {
    @Autowired
    OrderRepository orderRepository;
    public void handleDelivery(Order order){
        orderRepository.save(order);
    }
}
