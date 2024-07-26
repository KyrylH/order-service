package com.kyrylh.orderservice.service;

import com.kyrylh.orderservice.model.Order;
import com.kyrylh.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getOrdersWhereSentIsFalse() {
        return orderRepository.getOrderBySentIsFalse();
    }
    public void updateAll(List<Order> orders) {
        orderRepository.saveAll(orders);
    }
}
