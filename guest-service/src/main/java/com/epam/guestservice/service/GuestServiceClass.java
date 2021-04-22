package com.epam.guestservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.guestservice.model.User;


@Service
public class GuestServiceClass {

	public User addUser(User user) {
		return user;
	}

	public List<User> getUsers() {
		return Collections.emptyList();
	}

	public User getUserById(int userId) {
		return new User();
	}

	public String updateUser(User user, int userId) {
		return "User updated";
	}

	public String deleteUser(int userId) {
		return "User updated";
	}
}
