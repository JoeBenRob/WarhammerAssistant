package com.bae.business;

public interface UserService {
	
	String addUser(String user);
	String getAllUser();
	String getAUser(int id);
	String updateUser(int id, String user);
	String deleteUser(int id);
}
