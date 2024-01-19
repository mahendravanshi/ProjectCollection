package com.mine.service;



import java.util.List;

import com.mine.entity.User;
import com.mine.exception.UserNotFoundException;
import com.mine.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private UserRepository repository;


    public User addUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        List<User> users = repository.findAll();
        System.out.println("Getting data from DB : " + users);
        return users;
    }

    public List<User> findByAddress(String address) {
        return repository.findByAddress(address);
    }

    public String deleteUser(User user) {
        repository.delete(user);
        return "User Removed";
    }


    public User findById(Integer id) {
        return repository.findById(id).orElseThrow(()->new UserNotFoundException("No user found with user id"+id));
    }


}
