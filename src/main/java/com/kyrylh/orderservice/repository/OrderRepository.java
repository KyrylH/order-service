package com.kyrylh.orderservice.repository;

import com.kyrylh.orderservice.model.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> getOrderBySentIsFalse();
}
