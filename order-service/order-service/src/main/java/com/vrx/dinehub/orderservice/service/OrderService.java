package com.vrx.dinehub.orderservice.service;

import com.vrx.dinehub.orderservice.dto.OrderDto;
import com.vrx.dinehub.orderservice.dto.OrderDtoFromFE;

public interface OrderService {
    OrderDto saveOrder(OrderDtoFromFE orderDtoFromFE);
}
