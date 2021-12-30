package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cap.controller.UserController;
import com.cap.model.Role;
import com.cap.model.User;
import com.cap.service.UserService;

@SpringBootTest(classes=ControllerMockitoTest.class)
public class ControllerMockitoTest {

	@InjectMocks
	UserController controller;
	
	
	@Mock
	UserService service;
	
     User user;
     
     @Mock
     PasswordEncoder passwordEncoder;
     
  
     
	
	@Test
	public void TestAddUser()
	{

		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","shubham","garg","garg","12345","male","xyz@gmail.com","1234","agra",role1,"shubhamg");
		 when(service.createUser(user)).thenReturn(user);
		 assertEquals(user,controller.create(user));
     	
 
	}
	

	
	@Test
	public void TestFindByName()
	{

		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","shubham","garg","garg","12345","male","xyz@gmail.com","1234","agra",role1,"shubhamg");
		 when(service.findUserName("Tarunk")).thenReturn(user);
		 
		 assertEquals(user,controller.getByName("Tarunk"));
		
	}

	
	

}
