package com.micro.delivery;

import com.micropos.datatype.cart.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class DeliveryApplication {

    public static void main(String[] args){
        SpringApplication.run(DeliveryApplication.class,args);
    }

}
