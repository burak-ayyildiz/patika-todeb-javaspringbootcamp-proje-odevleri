package com.proje.odevi.model.mapper;

import com.proje.odevi.model.dto.OrderDTO;
import com.proje.odevi.model.entity.Orders;


public class OrderMapper {
    public OrderDTO toDTO(Orders orders) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderName(orders.getName());
        orderDTO.setTotalPrice(orders.getTotalPrice());
        return orderDTO;
    }

    public static Orders toEntity(OrderDTO orderDTO) {
        Orders orders = new Orders();
        orders.setName(orders.getName());
        orders.setTotalPrice(orders.getTotalPrice());
        return orders;
    }
}
