package com.epam.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guest.model.User;
import com.epam.guest.service.GuestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GuestControllerImpl implements GuestController {

	@Autowired
	private GuestService guestServiceClass;

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
