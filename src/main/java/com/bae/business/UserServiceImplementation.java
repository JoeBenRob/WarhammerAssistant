package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.UserRepo;

public class UserServiceImplementation implements UserService {

	@Inject
	UserRepo userRepo;
	
	@Override
	public String addUser(String user) {
		return userRepo.createUser(user);
	}

	@Override
	public String getAllUser() {
		return userRepo.getAllUser();
	}
	@Override
	public String getAUser(int id) {
		return userRepo.getAUser(id);
	}

	@Override
	public String updateUser(int id, String user) {
		return userRepo.updateUser(id, user);
	}

	@Override
	public String deleteUser(int id) {
		return userRepo.deleteUser(id);
	}

}
