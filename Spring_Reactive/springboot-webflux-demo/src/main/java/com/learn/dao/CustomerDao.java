package com.learn.dao;

import com.learn.dto.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i) throws InterruptedException {
        Thread.sleep(1000);
    }

      public List<Customer> getCustomers() throws InterruptedException {

          return  IntStream.rangeClosed(1,50)
                  .peek(Thread.sleep(1000))
                  .mapToObj(i->new Customer(i,"customer "+i))
                  .collect(Collectors.toList());

      }
}
