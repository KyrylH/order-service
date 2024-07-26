package com.kyrylh.orderservice.service.mapper;

import com.kyrylh.orderservice.model.Order;
import com.kyrylh.orderservice.model.request.OrderRequest;
import com.kyrylh.orderservice.model.response.OrderResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper{
    @Override
    public Order mapToOrder(OrderRequest request) {
        Order order = new Order();
        order.setSurname(request.getSurname());
        order.setProductName(request.getProductName());
        order.setProductCount(request.getProductCount());
        return order;
    }

    @Override
    public OrderResponse mapToResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setSurname(order.getSurname());
        orderResponse.setProductName(order.getProductName());
        orderResponse.setProductCount(order.getProductCount());
        return orderResponse;
    }
}
