package com.practice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff,String> {

}
