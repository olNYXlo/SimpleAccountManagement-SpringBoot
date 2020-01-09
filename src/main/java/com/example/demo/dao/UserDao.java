package com.example.demo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserDao extends MongoRepository<User, String>{
	
	@Query("{username:'?0'}")
	User findUserByUsername(String username);
	
	

}
