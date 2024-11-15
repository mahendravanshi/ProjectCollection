package com.ford.fordScenario.service;

import com.ford.fordScenario.model.User;
import com.ford.fordScenario.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User save(User user) {

        if(user==null){
            throw new RuntimeException("User is null");
        }
        return userRepo.save(user);
    }


    public User findById(UUID id) {

         Optional<User> user = userRepo.findById(id);

       if(user.isPresent()){
           return user.get();
       }
       else{
           throw new RuntimeException("User not found with user id "+id);
       }

    }
}
