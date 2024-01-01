package com.inspiron.feignClient.repo;


import com.inspiron.feignClient.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
