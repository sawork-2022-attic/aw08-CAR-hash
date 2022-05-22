package com.micropos.cart.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.micropos.cart.dto.ItemDto;
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
 * InlineObjectDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-22T23:13:29.141727500+08:00[Asia/Shanghai]")
public class InlineObjectDto   {

  @JsonProperty("cart")
  @Valid
  private List<ItemDto> cart = null;

  @JsonProperty("usrId")
  private String usrId;

  public InlineObjectDto cart(List<ItemDto> cart) {
    this.cart = cart;
    return this;
  }

  public InlineObjectDto addCartItem(ItemDto cartItem) {
    if (this.cart == null) {
      this.cart = new ArrayList<>();
    }
    this.cart.add(cartItem);
    return this;
  }

  /**
   * Get cart
   * @return cart
  */
  @Valid 
  @Schema(name = "cart", required = false)
  public List<ItemDto> getCart() {
    return cart;
  }

  public void setCart(List<ItemDto> cart) {
    this.cart = cart;
  }

  public InlineObjectDto usrId(String usrId) {
    this.usrId = usrId;
    return this;
  }

  /**
   * Get usrId
   * @return usrId
  */
  
  @Schema(name = "usrId", required = false)
  public String getUsrId() {
    return usrId;
  }

  public void setUsrId(String usrId) {
    this.usrId = usrId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObjectDto inlineObject = (InlineObjectDto) o;
    return Objects.equals(this.cart, inlineObject.cart) &&
        Objects.equals(this.usrId, inlineObject.usrId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cart, usrId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObjectDto {\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    usrId: ").append(toIndentedString(usrId)).append("\n");
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

