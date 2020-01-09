package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserAccounts")
public class User {
	
	@Id
	private String id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String mobileNo;
	private String password;

	
	
	
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getMobileNo() {
		return mobileNo;
	}




	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}




	@Override
	public String toString() {
		return "User{" + "id= '" + id + '\'' +
				", username= '" + username +'\'' +
				", firstname= '" + firstname +'\'' +
				", lastname= '" + lastname + '\'' +
				", email= '" + email + '\'' +
				", mobileNo= '" + mobileNo + '\'' +
				", password= '" + password + '}';
	}
	
	

}
