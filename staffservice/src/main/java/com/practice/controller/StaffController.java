package com.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.Staff;
import com.practice.repo.StaffRepository;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {

	@Autowired
	private StaffRepository staffrepository;
	

	
	// add the staff
	
	@PostMapping(value = "/AddStaff")
	@Transactional
	@CrossOrigin
	public String saveStaff(@RequestBody Staff staff)
	{
		staffrepository.save(staff);

	return "Added staff with id : " + staff.getId();
	
}
//find all the staff which have added into the database
	 @CrossOrigin("http://localhost:4200")
   @GetMapping("/findAllThestaff")
  
   public List<Staff>getStaffs()
   {
	   return staffrepository.findAll();
	   
   }
   // find the specific staff through there id
   
   @GetMapping("/findStaff/{id}")
   @CrossOrigin
   public Optional<Staff>getStaffs(@PathVariable String id)
   {
	   return staffrepository.findById(id);
   }
   
   //delete the specific staff through there id
   
   @DeleteMapping("/deleteStaff/{id}")
   @Transactional
   public String deletestaff(@PathVariable String id)
   {
	   staffrepository.deleteById(id);
	   return "staff have been Deleted with id: "+ id;
   }
   
 
}