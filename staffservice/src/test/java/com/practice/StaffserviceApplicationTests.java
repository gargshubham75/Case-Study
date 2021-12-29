package com.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.repo.StaffRepository;
import com.practice.service.StaffService;

@RunWith(SpringRunner.class)
@SpringBootTest
class StaffserviceApplicationTests {

	@Autowired
	private StaffService service;
	
	@MockBean
	private StaffRepository staffrepository;


	@Test
	public void getAdminTest() {
		when(staffrepository.findAll()).thenReturn(Stream
				.of(new Staff("01","shubham","agra","101","10000","24","manager","manager@gmail.com"),new Staff("02","garg","delhi","200","10000","22","dupty manager","dupty@gmail.com")).collect(Collectors.toList()));
		assertEquals(2,service.getstaffs().size());
	}
	
	@Test
	public void saveStaffTest() {
		Staff staff=new Staff("01","01","available","18-12-2021","20-12-2021","1001","double bed","1000");
		when(staffrepository.save(staff)).thenReturn(staff);
		assertEquals(staff,service.addstaff(staff));
	}
	
	@Test
	public void deletestaffTest() {
		Staff room=new Staff("01","01","available","18-12-2021","20-12-2021","1001","double bed","1000");
		service.deletestaff(room);
	}
	

	

}

