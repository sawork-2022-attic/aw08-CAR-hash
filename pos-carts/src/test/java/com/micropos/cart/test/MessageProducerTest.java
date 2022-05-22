package com.micropos.cart.test;

import com.micropos.cart.CartApplication;
import com.micropos.cart.producer.MessageProducer;
import com.micropos.datatype.cart.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CartApplication.class})
public class MessageProducerTest {
    @Autowired
    MessageProducer messageProducer;

    @Test
    public void testSend(){
        messageProducer.send("hello");
    }

    @Test
    public void testSendItem(){
        Item item=new Item();
        item.productId="123";
        item.quantity=5;
        messageProducer.sendItem(item);
    }
}
