package com.micropos.cart.rest;

import com.micropos.cart.api.CartApi;
import com.micropos.cart.dto.InlineObjectDto;
import com.micropos.cart.dto.ItemDto;
import com.micropos.cart.dto.ItemFieldsDto;
import com.micropos.cart.integration.DeliveryGateway;
import com.micropos.cart.mapper.ItemMapper;
import com.micropos.cart.service.ICartService;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api")
public class CartController implements CartApi{
    private final ItemMapper itemMapper;

    private final ICartService cartService;

    @Autowired
    DeliveryGateway deliveryGateway;

    @Autowired
    RestTemplate restTemplate;

    public CartController(ICartService cartService, ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<List<ItemDto>> addItem(ItemFieldsDto itemFieldsDto) {
        if (!cartService.checkProduct(itemFieldsDto.getProductId())){
            System.out.println("Product Not Found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ItemDto> itemDtos=itemFieldsDto.getCart();
        List<Item> cart;
        Item newItem=new Item(itemFieldsDto.getProductId(),itemFieldsDto.getQuantity());
        if(itemDtos==null || itemDtos.isEmpty()){
            cart=new ArrayList<>();
            cart.add(newItem);
            return new ResponseEntity<>(new ArrayList<>(itemMapper.toProductsDto(cart)), HttpStatus.OK);
        }
        Collection<Item> items=itemMapper.toProducts(itemDtos);
        cart =new ArrayList<>(items);
        Item item=itemMapper.toProduct(itemMapper.toProductDto(newItem));
        cart=cartService.addItem(item,cart);

        return new ResponseEntity<>(new ArrayList<>(itemMapper.toProductsDto(cart)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ItemDto>> delItem(ItemFieldsDto itemFieldsDto) {
        if (!cartService.checkProduct(itemFieldsDto.getProductId())){
            System.out.println("Product Not Found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ItemDto> itemDtos=itemFieldsDto.getCart();
        List<Item> cart;
        Item newItem=new Item(itemFieldsDto.getProductId(),itemFieldsDto.getQuantity());
        if(itemDtos==null || itemDtos.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
        Collection<Item> items=itemMapper.toProducts(itemDtos);
        cart =new ArrayList<>(items);
        Item item=itemMapper.toProduct(itemMapper.toProductDto(newItem));
        cart=cartService.delItem(item,cart);
        return new ResponseEntity<>(new ArrayList<>(itemMapper.toProductsDto(cart)), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<ItemDto>> makeAnOrder(InlineObjectDto inlineObjectDto) {
        List<Item> items= new ArrayList<>(itemMapper.toProducts(inlineObjectDto.getCart()));

        Order order=new Order(inlineObjectDto.getUsrId(),items);

        System.out.println(order.usrId);

        String uri = "http://localhost:8084/show";

        restTemplate.postForEntity(uri,order,null);

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }
}
