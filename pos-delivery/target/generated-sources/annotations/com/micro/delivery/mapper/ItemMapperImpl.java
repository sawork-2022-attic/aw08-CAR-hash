package com.micro.delivery.mapper;

import com.micropos.datatype.cart.Item;
import com.micropos.products.dto.ItemDto;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Collection<ItemDto> toProductsDto(Collection<Item> products) {
        if ( products == null ) {
            return null;
        }

        Collection<ItemDto> collection = new ArrayList<ItemDto>( products.size() );
        for ( Item item : products ) {
            collection.add( toProductDto( item ) );
        }

        return collection;
    }

    @Override
    public Collection<Item> toProducts(Collection<ItemDto> products) {
        if ( products == null ) {
            return null;
        }

        Collection<Item> collection = new ArrayList<Item>( products.size() );
        for ( ItemDto itemDto : products ) {
            collection.add( toProduct( itemDto ) );
        }

        return collection;
    }

    @Override
    public Item toProduct(ItemDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Item item = new Item();

        item.productId = productDto.getProductId();
        item.quantity = productDto.getQuantity();

        return item;
    }

    @Override
    public ItemDto toProductDto(Item pet) {
        if ( pet == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setProductId( pet.productId );
        itemDto.setQuantity( pet.quantity );

        return itemDto;
    }
}
