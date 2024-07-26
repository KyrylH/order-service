package com.kyrylh.orderservice.controller;

import com.kyrylh.orderservice.mapper.OrderMapper;
import com.kyrylh.orderservice.model.request.OrderRequest;
import com.kyrylh.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping({"/","order"})
    public String orderPage() {
        return "order";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView addOrder(@ModelAttribute @Valid OrderRequest order) {
        return orderService.addOrder(orderMapper.mapToOrder(order));
    }

}
