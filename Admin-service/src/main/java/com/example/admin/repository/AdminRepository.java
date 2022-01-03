package com.example.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
	Admin findByUserName(String username);

}
