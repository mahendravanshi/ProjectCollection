package com.unit_testing.Unit_testing;

import com.unit_testing.Unit_testing.entity.User;
import com.unit_testing.Unit_testing.repository.ServiceRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ServiceRepo serviceRepo;

    @Test
    public void getUser_success(){
//        User user1 = new User(1, "Susheel", "sushil@gmail.com","1234567890");
        User user1 = Mockito.mock(User.class);
        Mockito.when(user1.getId()).thenReturn(1);
        Mockito.when(user1.getEmail()).thenReturn("sushil@gmail.com");
        Mockito.when(user1.getName()).thenReturn("Susheel");
        Mockito.when(user1.getMobile()).thenReturn("1234567890");
        User persist = testEntityManager.merge(user1);
        Optional<User> user2 = serviceRepo.findById(1);
        Assertions.assertEquals(persist, user2.get());
    }
}
