package com.bae.persistence.repository;

public interface UserRepo {

	String getAllUser();
	String createUser(String user);
	String deleteUser(int id);
	String updateUser(int id, String user);
	String getAUser(int id);
	
}
