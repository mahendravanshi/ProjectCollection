package com.unit_testing.Unit_testing.service;

import com.unit_testing.Unit_testing.entity.User;
import com.unit_testing.Unit_testing.repository.ServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ServiceRepo serviceRepo;
    private final AccountService accountService;
    public User save(User user){
        return serviceRepo.save(user);
    }
    public List<User> getUsers(){
        return serviceRepo.findAll();
    }
    public Optional<User> findById(Integer id){
       return serviceRepo.findById(id);
    }

    public void deleteUser(Integer id){
        Optional<User> byId = serviceRepo.findById(id);
        if(byId.isPresent()){
            serviceRepo.deleteById(id);
        }else{
            throw new RuntimeException("error");
        }
    }

    public static String getAccountName(){
        AccountService accountService1 = new AccountService();
        return accountService1.getAccountName();
    }
}
