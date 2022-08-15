package com.proje.odevi.controller;

import com.proje.odevi.model.dto.OrderDTO;
import com.proje.odevi.model.entity.Orders;
import com.proje.odevi.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/all")
    public ResponseEntity getAllOrders(){
       List<Orders> allOrders = orderService.getAllOrders();
    return  ResponseEntity.ok(allOrders);
    }


    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable("id") Long id) {
        Orders byId;
        try {
            byId = orderService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewOrder(@RequestBody OrderDTO order) {
        Orders respOrders = orderService.create(order);
        if (respOrders == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Order could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respOrders);
    }

    @DeleteMapping
    public ResponseEntity deleteOrder(@RequestParam(name = "id") Long id) {
        try {
            orderService.delete(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Related Order deleted successfully");
    }

    @PutMapping("/{orders}")
    public ResponseEntity updateOrder(
            @PathVariable String name,
            @RequestBody OrderDTO order) {
      Orders update = orderService.update(name, order);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Order could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

}
