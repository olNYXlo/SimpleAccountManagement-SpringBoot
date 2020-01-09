package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean login(String username, String password) {
		boolean status = false;
		User retrievedUser = userDao.findUserByUsername(username);
		if (retrievedUser == null) {
			System.out.println("Username does not exist");
		}
		else {
			if (password.contentEquals(retrievedUser.getPassword())) {
				status = true;
			}
			else {
				System.out.println("Incorrect Password Entered");
			}
			
		}			
		return status;
	}

	@Override
	public boolean registration(User newUser) {
		boolean status = false;
		
		User retrievedUser = userDao.findUserByUsername(newUser.getUsername());
		if (retrievedUser == null) {
			userDao.save(newUser);
			status = true;
			System.out.println("User created");
		}
		else {
			System.out.println("Username already exists, please choose a different username");
		}
		
		return status;
	}

	@Override
	public ArrayList<User> getAllUserAccounts() {
		
		return (ArrayList<User>) userDao.findAll();
	}

	@Override
	public boolean deleteUseraccount(String username) {
		boolean status = false;
		User retrievedUser = userDao.findUserByUsername(username);
		if (retrievedUser != null) {
			userDao.delete(retrievedUser);
			status = true;
			System.out.println("User deleted");
		}
		else {
			System.out.println("Username does not exists, please choose a different username");
		}
		
		return status;
	}

	@Override
	public boolean resetPassword(String username) {
		boolean status = false;
		User retrievedUser = userDao.findUserByUsername(username);
		if (retrievedUser != null) {
			retrievedUser.setPassword("Password123!");
			userDao.save(retrievedUser);
			status = true;
			System.out.println("User Account Password Reset To : Password123!");
		}
		else {
			System.out.println("Username does not exists, please choose a different username");
		}
		
		return status;
	}
	
	
	
	
}
