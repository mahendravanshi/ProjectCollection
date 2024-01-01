package com.inspiron.feignClient.Orders.repo;

import com.inspiron.feignClient.Orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query("SELECT o FROM Order o WHERE o.userId = ?1")
    public List<Order> getAllOrdersOfAUser(Integer userId);


}
