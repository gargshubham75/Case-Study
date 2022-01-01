package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.cap.model.Role;
import com.cap.model.User;
import com.cap.repository.RoleRepository;
import com.cap.repository.UserRepository;
import com.cap.service.UserService;

@SpringBootTest(classes = UserServiceTest.class)
public class UserServiceTest {
	
	@Mock
	UserRepository repo;
	
	@Mock
	RoleRepository role;
	
	@InjectMocks
	UserService service;
	
     User user;
     
     @Mock
     PasswordEncoder passwordEncoder;
     
     
     
	
	@Test
	public void TestAddAdmin()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","shubham","garg","garg","12345","male","xyz@gmail.com","1234","agra",role1,"shubhamg");
     	when(repo.save(user)).thenReturn(user);
        assertEquals(user, service.createUser(user));
 
	}
	
//	@Test
//	public void TestUpdateById()
//	{
//		Set<Role> role1 = new HashSet<Role>();
//		role1.add(new Role(1l,"User"));
//		 user = new User ("1","Tarun","Kumar","Nanda","xyz@gmail.com","1234",role1,"Tarunk");
//		Optional<User> op = Optional.of(user);
//		when(repo.findById("1")).thenReturn(op);
//		when(repo.save(op.get())).thenReturn(user);
//		assertEquals(user,service.updateById("1", op.get()));
//	}
//	
	@Test
	public void TestFindByName()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","shubham","garg","garg","12345","male","xyz@gmail.com","1234","agra",role1,"shubhamg");
		 when(repo.findByUserName("shubhamg")).thenReturn(user);
		 assertEquals(user,service.findUserName("shubhamg"));
		
	}

	
}
