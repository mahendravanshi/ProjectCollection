package com.inspiron.feignClient.Orders.service;


import com.inspiron.feignClient.Orders.entity.Order;
import com.inspiron.feignClient.Orders.repo.OrderRepo;
import com.inspiron.feignClient.Orders.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

      @Autowired
      OrderRepo orderRepo;

        public Order addOrder(Order o) {
            System.out.println("Order placed");
            Order savedOrder = orderRepo.save(o);
            return savedOrder;
        }

        public List<Order> getallOrdersOfAUser(Integer userId){

            List<Order> lists = orderRepo.getAllOrdersOfAUser(userId);

           return  lists;
        }


       public  Order getOrder(Integer oid){


            Optional<Order> o = orderRepo.findById(oid);

            if(o.isPresent()) return o.get();
            else{
                throw new CustomException("Order not found");
            }

       }



    public Order updatedOrder(Order updatedOrder){
        System.out.println("Order updated successfully");
        return orderRepo.save(updatedOrder);
    }

    public String deleteOrder(Integer id){


         orderRepo.deleteById(id);

        return "Order with order id "+id+"delete successfully";
    }



}
