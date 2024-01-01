package com.inspiron.feignClient.ms;


import com.inspiron.feignClient.Entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(name="ORDERSERVICE",url="http://localhost:8080/orders")
public interface FeignCLientService {

      @GetMapping("/userId/{userId}/getAllOrdersOfUser")
      List<Order> getallOrdersOfAUser(@PathVariable Integer userId);


}
