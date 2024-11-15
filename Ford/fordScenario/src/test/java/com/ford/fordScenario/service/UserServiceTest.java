package com.ford.fordScenario.service;


import com.ford.fordScenario.model.User;
import com.ford.fordScenario.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


      @Mock
      private UserRepo userRepo;

      @InjectMocks
     private UserService userService;

//      private User user;

//      @BeforeEach
//      public void setUp(){
//
//            user = mock(User.class);
//            UUID id = UUID.randomUUID();
//            Mockito.when(user.getId()).thenReturn(id);
//            Mockito.when(user.getFullName()).thenReturn("ABC BCD");
//            Mockito.when(user.getRegisteredDate()).thenReturn(LocalDate.now());
//            Mockito.when(user.getTotalRides()).thenReturn(10);
//      }

      @Test
     public void saveUserTest(){
          User user = new User();
            UUID id = UUID.randomUUID();
            int totalRides = 10;
            user.setId(id);
            user.setFullName("ABC BCD");
            user.setRegisteredDate(LocalDate.now());
            user.setTotalRides(10);


          when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
          User expectedUser = userService.save(user);

          Assertions.assertEquals(expectedUser.getFullName(),user.getFullName());
          assertThat(expectedUser.getId()).isNotNull();
          assertThat(expectedUser.getTotalRides()).isEqualTo(10);
      }

      @Test
      void check_if_user_null(){

//          User user = new User();
//          UUID id = UUID.randomUUID();
//          int totalRides = 10;
//          user.setId(id);
//          user.setFullName("ABC BCD");
//          user.setRegisteredDate(LocalDate.now());
//          user.setTotalRides(10);
          User user = null;


          when(userRepo.findById(null)).thenThrow(new RuntimeException("This is error"));
            assertThrows(RuntimeException.class, ()->userService.findById(null),"this is message");
      }


      @Test
      public void check_registerUser_returnsNull(){

            // when(userRepo.save(null)).thenReturn(null);
             Assertions.assertThrows(RuntimeException.class,()->userService.save(null),"User is null");

      }



    @Test
    void check_findById_returnEmpty(){

        when(userRepo.findById(Mockito.any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(Exception.class,()->userService.findById(Mockito.any(UUID.class)),"User not found with user id "+UUID.class);

    }




}
