package com.unit_testing.Unit_testing;

import com.unit_testing.Unit_testing.controller.LoginController;
import com.unit_testing.Unit_testing.service.AccountService;
import com.unit_testing.Unit_testing.service.LoginService;
import com.unit_testing.Unit_testing.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mockStatic;

//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class LoginControllerTest {
    @MockBean
    private LoginService loginService;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void login_success() throws Exception {
//        String email = "sushil";
//        String password = "password";
//        Mockito.when(loginService.login(email, password)).thenReturn(true);
//        String res = loginController.login(email, password);
//        Assertions.assertEquals(res, "login successful");
//    }
//
//    @Test
//    public void login_failed(){
//        Mockito.when(loginService.login("sk","pass")).thenThrow(new RuntimeException());
//        Assertions.assertThrows(RuntimeException.class, ()->{
//            loginController.login("sk", "pass");
//        });
//    }

    @Test
    public void login_success() throws Exception {
        String email = "sushil";
        String password = "pass";
        Mockito.when(loginService.login(email, password)).thenReturn(3);
        Mockito.when(loginService.getUserName()).thenReturn("Inspiron");
//        Mockito.when(UserService.getAccountName()).thenReturn("Inspiron");
        String res = loginController.login(email, password);
        Assertions.assertEquals(res, "Inspiron");
    }

    @Test
    public void login_failed(){
        Mockito.when(loginService.login("", "")).thenReturn(4);
        String res = loginController.login("","");
        Assertions.assertEquals(res, "4");
    }

    @Test
    public void login_successful(){
        try (MockedStatic mocked = Mockito.mockStatic(UserService.class)){
            Mockito.when(loginService.login("sushil", "pass")).thenReturn(3);
            mocked.when(UserService::getAccountName).thenReturn("Inspiron");
            Mockito.when(loginService.getUserName()).thenReturn("Inspiron");
            Assertions.assertEquals(loginController.login("sushil","pass"), "Inspiron");
        }
    }

    @Test
    public void login_failed1(){
        Mockito.when(loginService.login("", "")).thenReturn(4);
        Assertions.assertEquals(loginController.login("",""), "4");
    }

}
