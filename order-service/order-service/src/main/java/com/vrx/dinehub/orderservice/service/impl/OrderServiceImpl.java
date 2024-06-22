package com.vrx.dinehub.orderservice.service.impl;

import com.netflix.discovery.converters.Auto;
import com.vrx.dinehub.orderservice.dto.OrderDto;
import com.vrx.dinehub.orderservice.dto.OrderDtoFromFE;
import com.vrx.dinehub.orderservice.dto.UserDto;
import com.vrx.dinehub.orderservice.entity.Orders;
import com.vrx.dinehub.orderservice.mapper.OrderMapper;
import com.vrx.dinehub.orderservice.repo.OrderRepository;
import com.vrx.dinehub.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public OrderDto saveOrder(OrderDtoFromFE orderDtoFromFE) {
        UserDto userDto = fetchUserDetailsFromUserId(orderDtoFromFE.getUserId());
        Orders orders = Orders.builder()
                .userDto(userDto)
                .orderId(UUID.randomUUID().toString())
                .foodItemDtoList(orderDtoFromFE.getFoodItemDtoList())
                .restaurantDto(orderDtoFromFE.getRestaurantDto())
                .build();
        Orders saved = orderRepository.save(orders);
        return OrderMapper.MAPPER.mapOrderToOrderDto(saved);

    }

    private UserDto fetchUserDetailsFromUserId(String userId) {
        return restTemplate.getForObject("http://USER-DETAILS-SERVICE/users/" + userId, UserDto.class);
    }
}
