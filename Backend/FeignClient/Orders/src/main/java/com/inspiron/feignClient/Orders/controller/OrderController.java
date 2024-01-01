package com.inspiron.feignClient.Orders.controller;



import com.inspiron.feignClient.Orders.entity.Order;
import com.inspiron.feignClient.Orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        System.out.println(order.getOrderId()+" "+order.getPrice());
        Order addedOrder = orderService.addOrder(order);
        return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
    }


    @GetMapping("/userId/{userId}/getAllOrdersOfUser")
    public ResponseEntity<List<Order>> getAllOrdersOfAUser(@PathVariable Integer userId){

        return new ResponseEntity<List<Order>>(orderService.getallOrdersOfAUser(userId),HttpStatus.ACCEPTED);
    }


    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer orderId, @RequestBody Order updatedOrder) {
        updatedOrder.setOrderId(orderId);
        Order updated = orderService.updatedOrder(updatedOrder);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) {
        String result = orderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }


}

