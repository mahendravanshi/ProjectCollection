package com.ford.fordScenario.repo;


import com.ford.fordScenario.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(connection= EmbeddedDatabaseConnection.H2)
public class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    void userRepo_saved_return_userRepo(){

         User user = new User();
         user.setId(UUID.randomUUID());
         user.setFullName("ABC BCD");
         user.setTotalRides(10);
         user.setRegisteredDate(LocalDate.now());

         User user1 = userRepo.save(user);


         Assertions.assertThat(user1).isNotNull();
         Assertions.assertThat(user1.getId()).isNotNull();


    }
}
