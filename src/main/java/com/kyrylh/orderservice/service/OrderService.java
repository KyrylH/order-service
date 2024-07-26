package com.kyrylh.orderservice.service;

import com.kyrylh.orderservice.model.Order;
import java.io.IOException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface OrderService {
    ModelAndView addOrder(Order order);

    void save(Order order);

    List<Order> getOrdersWhereSentIsFalse();

    void updateAll(List<Order> orders);

    void sendOrdersToNextService() throws IOException;
}
