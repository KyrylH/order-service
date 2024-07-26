package com.kyrylh.orderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyrylh.orderservice.model.Order;
import com.kyrylh.orderservice.model.request.OrderRequest;
import com.kyrylh.orderservice.model.response.OrderResponse;
import com.kyrylh.orderservice.service.OrderService;
import com.kyrylh.orderservice.service.mapper.OrderMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ObjectMapper objectMapper;

    @GetMapping({"/","order"})
    public String orderPage() {
        return "order";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView addOrder(@ModelAttribute @Valid OrderRequest order) {
        orderService.save(orderMapper.mapToOrder(order));
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("containsMessage", true);
        modelAndView.addObject("message", "ok");
        return modelAndView;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("containsMessage", true);
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    @Scheduled(cron = "0 */5 * ? * *")
    public void sendOrdersToNextService() throws IOException, URISyntaxException {
        Response response = mock(Response.class);
        when(response.isSuccessful()).thenReturn(true);
        List<Order> orders = orderService.getOrdersWhereSentIsFalse();
        List<OrderResponse> orderResponses = orders.stream().map(orderMapper::mapToResponse).toList();
        String json = objectMapper.writeValueAsString(orderResponses);
        RequestBody body = RequestBody.create(json.getBytes());
        Request req =  mock(Request.class);
        OkHttpClient client = mock(OkHttpClient.class);
        when(client.newCall(req).execute()).thenReturn(response);
        when(response.isSuccessful()).thenReturn(true);
        if (response.isSuccessful()) {
            orders.forEach(o -> o.setSent(true));
            orderService.updateAll(orders);
        }
    }
}
