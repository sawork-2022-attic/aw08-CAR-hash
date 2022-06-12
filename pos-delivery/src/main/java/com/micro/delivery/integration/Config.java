package com.micro.delivery.integration;

import com.micro.delivery.service.DeliveryService;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.util.Set;

@Configuration
public class Config {
    @Bean
    DeliveryService deliveryService(){
        return new DeliveryService();
    }

    @Bean
    IntegrationFlow sendDeliveryWorkFlow(){
        return IntegrationFlows.from("deliveryChannel")
                .<Item>handle(System.out::println)
                .get();
    }
    @Bean
    IntegrationFlow handleDeliveryWorkFlow(){
        return IntegrationFlows.from(Http.inboundGateway("/order")
                        .requestPayloadType(Order.class)
                )
                .handle((o)->{
                    Order myOrder=(Order)o.getPayload();
                    System.out.println(myOrder.usrId);
                    deliveryService().handleDelivery(myOrder);
                })
                .get();
    }
}
