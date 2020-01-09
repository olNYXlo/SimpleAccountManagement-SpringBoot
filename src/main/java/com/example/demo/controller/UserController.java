package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/login")
	@ApiOperation(value="Method used to login")
	public boolean login (@RequestBody User user) {
		return userServiceImpl.login(user.getUsername(), user.getPassword());		
	}
	
	@PostMapping("/register")
	@ApiOperation(value="Method used to register user accounts & create new accounts for admin. New account cannot be created if username already exists")
	public boolean register(@RequestBody User user) {
		return userServiceImpl.registration(user);
	}
	
	@GetMapping("/accounts")
	@ApiOperation(value="Method used to get all user accounts for management operations")
	public ArrayList<User> getAllAccounts(){
		return userServiceImpl.getAllUserAccounts();
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Method used to delete a single account")
	public boolean deleteAccount(@RequestBody User user) {
		return userServiceImpl.deleteUseraccount(user.getUsername());
	}
	
	@PostMapping("/resetPassword")
	@ApiOperation(value="Method used to reset password for a single account")
	public boolean resetPassword(@RequestBody User user) {
		return userServiceImpl.resetPassword(user.getUsername());
	}
	
}
