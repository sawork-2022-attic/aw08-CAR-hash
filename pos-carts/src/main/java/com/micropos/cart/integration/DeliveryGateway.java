package com.micropos.cart.integration;

import com.micropos.datatype.cart.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway
public interface DeliveryGateway {
    @Gateway(requestChannel = "cart.delivery.input")
    void placeDelivery(Order order);
}
