package com.jwt.SpringJWT2.repository;

import com.jwt.SpringJWT2.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);


}
