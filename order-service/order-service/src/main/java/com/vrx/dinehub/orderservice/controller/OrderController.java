package com.vrx.dinehub.orderservice.controller;

import com.vrx.dinehub.orderservice.dto.OrderDto;
import com.vrx.dinehub.orderservice.dto.OrderDtoFromFE;
import com.vrx.dinehub.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDtoFromFE) {
        OrderDto orderDto = orderService.saveOrder(orderDtoFromFE);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
