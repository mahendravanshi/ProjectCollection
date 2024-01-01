package com.security.service;

import com.security.entity.Order;

public interface OrderService {

      Order addOrder(Order order);
      Order updateOrder(Order order);
      Order showAllOrders(Integer userId);
      Order findOrderById(Integer orderId);


}
