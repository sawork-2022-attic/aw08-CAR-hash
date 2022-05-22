package com.micro.delivery.repository;

import com.micropos.datatype.cart.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
    @Query("{usrId: ?0}")
    List<Order> findByUsrId(String usrId);
}
