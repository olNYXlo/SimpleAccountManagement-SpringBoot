package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.User;

public interface UserService {
	
	public boolean login(String username, String password);
	
	
	public boolean registration(User user);
	
	public ArrayList<User> getAllUserAccounts();
	
	public boolean deleteUseraccount(String username);
	
	public boolean resetPassword(String username);

}
