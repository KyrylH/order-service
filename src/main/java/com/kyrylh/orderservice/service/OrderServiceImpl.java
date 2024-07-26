package com.kyrylh.orderservice.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyrylh.orderservice.mapper.OrderMapper;
import com.kyrylh.orderservice.model.Order;
import com.kyrylh.orderservice.model.response.OrderResponse;
import com.kyrylh.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ObjectMapper objectMapper;

    @Override
    public ModelAndView addOrder(Order order) {
        save(order);
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("containsMessage", true);
        modelAndView.addObject("message", "ok");
        return modelAndView;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersWhereSentIsFalse() {
        return orderRepository.getOrderBySentIsFalse();
    }

    @Override
    public void updateAll(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    @Scheduled(cron = "0 */5 * ? * *")
    public void sendOrdersToNextService() throws IOException {
        Response response = mock(Response.class);
        when(response.isSuccessful()).thenReturn(true);
        List<Order> orders = getOrdersWhereSentIsFalse();
        List<OrderResponse> orderResponses = orders
                .stream()
                .map(orderMapper::mapToResponse)
                .toList();
        String json = objectMapper.writeValueAsString(orderResponses);
        RequestBody body = RequestBody.create(json.getBytes());
        Request req = mock(Request.class);
        OkHttpClient client = mock(OkHttpClient.class);
        when(client.newCall(req).execute()).thenReturn(response);
        when(response.isSuccessful()).thenReturn(true);
        if (response.isSuccessful()) {
            orders.forEach(o -> o.setSent(true));
            updateAll(orders);
        }
    }
}
