package com.example.spring_security_token.service;

import com.example.spring_security_token.config.UserInfoUserDetails;
import com.example.spring_security_token.entity.UserInfo;
import com.example.spring_security_token.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoDetailsService implements UserDetailsService {


    @Autowired
    private UserInfoRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repo.findByName(username);
        if (!userInfo.isPresent()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        UserInfo user = userInfo.get();
        System.out.println("Fetched user: " + user);

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            System.out.println("User password is empty for user: " + username);
            throw new IllegalArgumentException("User password is empty for user: " + username);
        }

        return new UserInfoUserDetails(user);
    }
}
