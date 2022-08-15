package com.proje.odevi.service;

import com.proje.odevi.model.dto.OrderDTO;
import com.proje.odevi.model.entity.Orders;
import com.proje.odevi.model.mapper.OrderMapper;
import com.proje.odevi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Orders> getAllOrders(){
        List <Orders> allOrders = orderRepository.findAll();
    return allOrders;
    }

    public Orders getById(Long id){
        Optional<Orders> byId = orderRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Order not found!"));
    }

    public Orders create(OrderDTO orderDTO) {
        Orders orders = OrderMapper.toEntity(orderDTO);
            return orderRepository.save(orders);

        }

    public void delete(Long id) {
        getById(id);
        orderRepository.deleteById(id);
    }

    public Orders update(String name, OrderDTO orders) {
        Optional<Orders> orderByName = orderRepository.findOrderByName(name);
        if (!orderByName.isPresent())
            return null;
        Orders updatedOrder = orderByName.get();
        if (!StringUtils.isEmpty(orders.getOrderName())) {
            updatedOrder.setName(orders.getOrderName());
        }
        if (!StringUtils.isEmpty(orders.getOrderName())) {
            updatedOrder.setName(orders.getOrderName());
        }

        return orderRepository.save(updatedOrder);
    }
}
