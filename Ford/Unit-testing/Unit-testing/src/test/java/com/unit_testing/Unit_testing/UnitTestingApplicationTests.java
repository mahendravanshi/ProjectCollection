package com.unit_testing.Unit_testing;

import com.unit_testing.Unit_testing.entity.User;
import com.unit_testing.Unit_testing.repository.ServiceRepo;
import com.unit_testing.Unit_testing.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UnitTestingApplicationTests {
//	@Mock
//	private ServiceRepo serviceRepo;
//	private MockMvc mockMvc;
//	@InjectMocks
//	private UserService userService;

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
//		List<User> user = new ArrayList<>();
//		User user1 = new User(1, "Susheel","sushil@gmail.com", "78787878");
//		User user2 = new User(2, "Abhiraj","abhiraj@gmail.com", "78787878");
//		User user3 = new User(3, "Rupesh","rupesh@gmail.com", "78787878");
//		user.add(user1);
//		user.add(user2);
//		user.add(user3);
//		Mockito.when(serviceRepo.findAll()).thenReturn(user);
//		List<User> actual = userService.getUsers();
//		Assertions.assertEquals(user, actual);
//		Assertions.assertEquals(user.size(), actual.size());
	}


}
