package com.micro.delivery.rest;

import com.micro.delivery.mapper.ItemMapper;
import com.micro.delivery.repository.OrderRepository;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import com.micropos.products.api.DeliveryApi;
import com.micropos.products.dto.ItemDto;
import com.micropos.products.dto.OrderDto;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class DeliveryController implements DeliveryApi {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public ResponseEntity<List<ItemDto>> showUserOrders(String orderId) {
        Optional<Order> order_op=orderRepository.findById(orderId);
        if(order_op.isPresent()){
            return new ResponseEntity<>(new ArrayList<>(itemMapper.toProductsDto(order_op.get().cart)),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<OrderDto>> findByUsrId(String usrId) {
        List<Order> orders=orderRepository.findByUsrId(usrId);
        List<OrderDto> ret=new ArrayList<>();
        for (Order order:orders
             ) {
            OrderDto orderDto=new OrderDto();
            orderDto.setOrderId(order.orderId);
            orderDto.setUsrId(order.usrId);
            orderDto.setContent(new ArrayList<>(itemMapper.toProductsDto(order.cart)));
            ret.add(orderDto);
        }
        return new ResponseEntity<>(ret,HttpStatus.OK);
    }


}
