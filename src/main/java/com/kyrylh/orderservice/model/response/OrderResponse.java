package com.kyrylh.orderservice.model.response;

import lombok.Data;

@Data
public class OrderResponse {
    private String surname;
    private String productName;
    private Integer productCount;
}
