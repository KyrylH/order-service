package com.kyrylh.orderservice.service.mapper;

import com.kyrylh.orderservice.model.Order;
import com.kyrylh.orderservice.model.request.OrderRequest;
import com.kyrylh.orderservice.model.response.OrderResponse;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper {
    Order mapToOrder(OrderRequest request);

    OrderResponse mapToResponse(Order order);
}
