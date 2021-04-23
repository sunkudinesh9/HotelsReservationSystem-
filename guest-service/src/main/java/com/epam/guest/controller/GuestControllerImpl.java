package com.epam.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<com.epam.guest.entity.User> addUser(User user) {
		log.info("Adding the user");
		com.epam.guest.entity.User userData = guestServiceClass.addUser(user);
		return new ResponseEntity<>(userData, HttpStatus.CREATED);
	}

	@Override
	public List<com.epam.guest.entity.User> getUsers() {
		return guestServiceClass.getUsers();
	}

	@Override
	public ResponseEntity<com.epam.guest.entity.User> getUserById(int userid) {
		com.epam.guest.entity.User userData = guestServiceClass.getUserById(userid);
		return new ResponseEntity<>(userData, HttpStatus.OK);
	}

	@Override
	public String updateUser(User user, int userid) {
		return guestServiceClass.updateUser(user, userid);
	}

	@Override
	public String deleteUserById(int userid) {
		return guestServiceClass.deleteUser(userid);
	}
}
