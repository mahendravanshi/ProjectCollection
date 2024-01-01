package com.security.service;

import com.security.entity.Order;
import com.security.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepo orderRepo;
    @Override
    public Order addOrder(Order order) {
        return  orderRepo.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public Order showAllOrders(Integer userId) {
        return null;
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return null;
    }
}
