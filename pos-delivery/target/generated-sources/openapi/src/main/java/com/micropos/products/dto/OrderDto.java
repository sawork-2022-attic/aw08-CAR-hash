package com.micropos.products.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.micropos.products.dto.ItemDto;
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
 * OrderDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-22T23:13:32.430727900+08:00[Asia/Shanghai]")
public class OrderDto   {

  @JsonProperty("orderId")
  private String orderId;

  @JsonProperty("usrId")
  private String usrId;

  @JsonProperty("content")
  @Valid
  private List<ItemDto> content = null;

  public OrderDto orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  
  @Schema(name = "orderId", required = false)
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public OrderDto usrId(String usrId) {
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

  public OrderDto content(List<ItemDto> content) {
    this.content = content;
    return this;
  }

  public OrderDto addContentItem(ItemDto contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Get content
   * @return content
  */
  @Valid 
  @Schema(name = "content", required = false)
  public List<ItemDto> getContent() {
    return content;
  }

  public void setContent(List<ItemDto> content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDto order = (OrderDto) o;
    return Objects.equals(this.orderId, order.orderId) &&
        Objects.equals(this.usrId, order.usrId) &&
        Objects.equals(this.content, order.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, usrId, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDto {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    usrId: ").append(toIndentedString(usrId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

