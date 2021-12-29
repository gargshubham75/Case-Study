package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Staff;
import com.practice.repo.StaffRepository;


@Service
public class StaffService {
	
@Autowired	
private StaffRepository staffrepository;
	
	public Staff addstaff( Staff staff)
	{
		return staffrepository.save(staff);
	}
    public List<Staff> getstaffs()
    {
    List<Staff>staff=staffrepository.findAll();
    return staff;
    }
  public Optional<Staff>getStaff(String id)
  {
	  return staffrepository.findById(id);
	  
  }
  public void deletestaff(Staff staff)
  {
	  staffrepository.delete(staff);
	  
  }

}
