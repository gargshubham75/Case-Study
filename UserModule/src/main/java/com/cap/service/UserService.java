package com.cap.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cap.model.User;
import com.cap.repository.RoleRepository;
import com.cap.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository repository2;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User createUser(User user)
	{
		if(user.getRole()!=null && user.getRole().size()>0)
		{
			repository2.saveAll(user.getRole());
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return repository.save(user);
	}

     public User findUserName(String username)
     {
    	 return repository.findByUserName(username);
     }
     
    
}
