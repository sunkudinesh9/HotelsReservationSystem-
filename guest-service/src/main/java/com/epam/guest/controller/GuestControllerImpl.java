package com.epam.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guest.entity.User;
import com.epam.guest.model.UserDto;
import com.epam.guest.service.GuestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GuestControllerImpl implements GuestController {

	@Autowired
	private GuestService guestService;

	@Override
	public ResponseEntity<User> addUser(UserDto userDto) {
		log.info("Adding the user");
		User user = guestService.addUser(userDto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@Override
	public List<User> getUsers() {
		return guestService.getUsers();
	}

	@Override
	public ResponseEntity<User> getUserById(int userid) {
		User user = guestService.getUserById(userid);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@Override
	public String updateUser(UserDto userDto, int userid) {
		return guestService.updateUser(userDto, userid);
	}

	@Override
	public String deleteUserById(int userid) {
		return guestService.deleteUser(userid);
	}
}
