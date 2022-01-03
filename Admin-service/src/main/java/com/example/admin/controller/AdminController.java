package com.example.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.model.Admin;
import com.example.admin.model.UserRequest;
import com.example.admin.model.UserResponse;
import com.example.admin.repository.AdminRepository;
import com.example.admin.service.AdminService;
import com.example.admin.util.JwtUtil;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil util;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return service.createAdmin(admin);
	}
	
	// Authentication for login
	@CrossOrigin(origins = "*")
		@PostMapping("/authenticates")
		public UserResponse genenrateTokenForUser(@RequestBody UserRequest request)throws Exception
		{
			try
			{
				System.out.println(request.getUsername()+"   "+request.getPassword());
//				System.out.println(repo.findByUserName(request.getUsername()).getRole());
				if(repo.findByUserName(request.getUsername()).getRole()!=null) {
					authenticationManager.authenticate(
							new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
							);
					
				}
				else
				{
					throw new Exception("Role is not defined");
				}

				
			}
			catch(Exception e)
			{
				throw new Exception("Invalid Credential");
			}
			String token = util.generateToken(request.getUsername());
			return new UserResponse(token);
		}
	
	
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/adminAll")
	public List<Admin> getadmin()
	{
		return service.getAdmin();
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/updateAdmin/{id}")
	public Admin update(@PathVariable("id") String id,@RequestBody Admin admin)
	{
		System.out.println(id);
		return service.updateById(id, admin);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public String delete(@PathVariable("id") String id)
	{
		return service.deleteAdmin(id);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/user/{username}")
	public Admin getByName(@PathVariable("username") String username)
	{
	  return service.findUserName(username);	
	}
	
	
	
}
