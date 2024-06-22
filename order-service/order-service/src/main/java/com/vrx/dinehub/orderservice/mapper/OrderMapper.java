package com.vrx.dinehub.orderservice.mapper;

import com.vrx.dinehub.orderservice.dto.OrderDto;
import com.vrx.dinehub.orderservice.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    Orders mapOrderDtoToOrders(OrderDto orderDto);

    OrderDto mapOrderToOrderDto(Orders orders);
}
