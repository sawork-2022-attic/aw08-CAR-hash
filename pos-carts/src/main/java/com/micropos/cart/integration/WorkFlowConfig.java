package com.micropos.cart.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;

@Configuration
public class WorkFlowConfig {
    @Bean
    IntegrationFlow sendDelivery(){
        return IntegrationFlows.from("cart.delivery.input")
                .handle(Http.outboundGateway("http://localhost:8084/order")
                        .httpMethod(HttpMethod.GET)
                )
                .get();
    }
}
