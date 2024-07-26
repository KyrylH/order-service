package com.kyrylh.orderservice.repository;

import com.kyrylh.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> getOrderBySentIsFalse();
}
