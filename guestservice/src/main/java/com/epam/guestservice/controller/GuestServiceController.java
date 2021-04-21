package com.epam.guestservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.epam.guestservice.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GuestServiceController implements GuestServiceControllerInterface {
	@Override
	public User addUser(User user) {
		log.info("Adding the user");
		return user;
	}

	@Override
	public String getUsers() {
		return "All Users";
	}

	@Override
	public String getUserById(int userId) {
		return "User is" + userId;
	}

	@Override
	public String updateUser(User user, int userId) {
		return "User updated";
	}

	@Override
	public String deleteUser(int userId) {
		return "User updated";
	}
}
