package com.micropos.datatype.cart;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("orders")
public class Order {
    @MongoId
    public String orderId;
    public String usrId;
    public List<Item> cart;
    public Order(String usrId,List<Item> cart){
        this.cart=cart;
        this.usrId =usrId;
        this.orderId=new ObjectId().toString();
    }
    public Order(List<Item> cart){
        this.cart=cart;
    }

    public Order(String orderId,String usrId,List<Item> cart){
        this.orderId=orderId;
        this.usrId=usrId;
        this.cart=cart;
    }

    public Order(){

    }


}
