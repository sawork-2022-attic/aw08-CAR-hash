package com.micropos.gateway.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.micropos.gateway.dto.ItemDto;
import com.micropos.gateway.dto.ItemFieldsAllOfDto;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * field for cart CRUD.
 */

@Schema(name = "ItemFields", description = "field for cart CRUD.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-22T23:13:30.901727+08:00[Asia/Shanghai]")
public class ItemFieldsDto   {

  @JsonProperty("productId")
  private String productId;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("cart")
  @Valid
  private List<ItemDto> cart = new ArrayList<>();

  public ItemFieldsDto productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @NotNull 
  @Schema(name = "productId", required = true)
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public ItemFieldsDto quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull 
  @Schema(name = "quantity", required = true)
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ItemFieldsDto cart(List<ItemDto> cart) {
    this.cart = cart;
    return this;
  }

  public ItemFieldsDto addCartItem(ItemDto cartItem) {
    this.cart.add(cartItem);
    return this;
  }

  /**
   * Get cart
   * @return cart
  */
  @NotNull @Valid 
  @Schema(name = "cart", required = true)
  public List<ItemDto> getCart() {
    return cart;
  }

  public void setCart(List<ItemDto> cart) {
    this.cart = cart;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemFieldsDto itemFields = (ItemFieldsDto) o;
    return Objects.equals(this.productId, itemFields.productId) &&
        Objects.equals(this.quantity, itemFields.quantity) &&
        Objects.equals(this.cart, itemFields.cart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, quantity, cart);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemFieldsDto {\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

