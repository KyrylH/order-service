package com.kyrylh.orderservice.model.response;

import lombok.Data;

@Data
public class OrderResponse {
    String surname;
    String productName;
    Integer productCount;
}
