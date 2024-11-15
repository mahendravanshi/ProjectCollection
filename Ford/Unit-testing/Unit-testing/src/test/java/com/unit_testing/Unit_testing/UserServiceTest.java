package com.unit_testing.Unit_testing;

import com.unit_testing.Unit_testing.entity.User;
import com.unit_testing.Unit_testing.repository.ServiceRepo;
import com.unit_testing.Unit_testing.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private ServiceRepo serviceRepo;

    @InjectMocks
    private UserService userService;


    @Test
    public void saveUser_success(){
        User user = new User(1, "Susheel", "sushil@gmail.com","1234567890");
       when(serviceRepo.save(user)).thenReturn(user);
        User user1 = userService.save(user);
        Assertions.assertEquals(user1.getId(), user.getId());
        Assertions.assertEquals(user1, user);
    }

    @Test
    public void getUser_success(){
        User user1 = new User(1, "Susheel", "sushil@gmail.com","1234567890");
        User user2 = new User(2, "Rupesh", "rupesh@gmail.com","1234567890");
        User user3 = new User(3, "Sparsh", "sparsh@gmail.com","1234567890");
        List<User> list = Arrays.asList(user1, user2, user3);
        when(serviceRepo.findAll()).thenReturn(list);
        List<User> expected = userService.getUsers();
        Assertions.assertEquals(expected.size(), list.size());
    }

    @Test
    public void getUserById_success(){
        User user1 = new User(1, "Susheel", "sushil@gmail.com","1234567890");
        when(serviceRepo.findById(1)).thenReturn(Optional.of(user1));
        Optional<User> byId = userService.findById(1);

        Assertions.assertEquals(byId, Optional.of(user1));
        Assertions.assertEquals(byId.get().getId(), user1.getId());
    }

}
