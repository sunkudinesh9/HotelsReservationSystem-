package com.epam.guestservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guestservice.model.User;
import com.epam.guestservice.service.GuestServiceClass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GuestServiceController implements GuestServiceControllerInterface {

	@Autowired
	private GuestServiceClass guestServiceClass;

	@Override
	public User addUser(User user) {
		log.info("Adding the user");
		return guestServiceClass.addUser(user);
	}

	@Override
	public List<User> getUsers() {
		return guestServiceClass.getUsers();
	}

	@Override
	public User getUserById(int userid) {
		return guestServiceClass.getUserById(userid);
	}

	@Override
	public String updateUser(User user, int userId) {
		return guestServiceClass.updateUser(user, userId);
	}

	@Override
	public String deleteUser(int userId) {
		return guestServiceClass.deleteUser(userId);
	}
}
