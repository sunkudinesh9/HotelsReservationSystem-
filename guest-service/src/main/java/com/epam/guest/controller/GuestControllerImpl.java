package com.epam.guest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guest.entity.User;
import com.epam.guest.model.ApiResponse;
import com.epam.guest.model.UserDto;
import com.epam.guest.service.GuestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GuestControllerImpl implements GuestController {

	@Autowired
	private GuestService guestService;

	@Override
	public ResponseEntity<ApiResponse<User>> addUser(UserDto userDto) {
		log.info("Entired into the " + GuestControllerImpl.class.getName() + "addUser");
		User user = guestService.addUser(userDto);
		return new ResponseEntity<>(new ApiResponse<>(user, new Date(), "User created "), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<User>> getUsers() {
		log.info("Entired into the " + GuestControllerImpl.class.getName() + "getUsers");
		return new ResponseEntity<>(guestService.getUsers(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<User>> getUserById(int userid) {
		log.info("Entired into the " + GuestControllerImpl.class.getName() + "getUserById");
		User user = guestService.getUserById(userid);
		log.info("User has retrieved by the userid" + userid);
		return new ResponseEntity<>(new ApiResponse<>(user, new Date(), "User has retrieved"), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<User>> updateUser(UserDto userDto, int userid) {
		log.info("Entired into the " + GuestControllerImpl.class.getName() + "updateUser");
		User user = guestService.updateUser(userDto, userid);
		log.info("User has retrieved by the userid" + userid);
		return new ResponseEntity<>(new ApiResponse<>(user, new Date(), "User" + userid + "has updated"),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<User>> deleteUserById(int userid) {
		log.info("Entired into the " + GuestControllerImpl.class.getName() + "deleteUserById" + userid);
		return new ResponseEntity<>(new ApiResponse<>(null, new Date(), guestService.deleteUser(userid)),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<User>> getUserByUserName(String username) {
		log.info("Entired into the " + GuestControllerImpl.class.getName() + "getUserByUserName");
		User user = guestService.getUserByUserName(username);
		return new ResponseEntity<>(new ApiResponse<>(user, new Date(), "User with " + username + " has retrieved"),
				HttpStatus.OK);
	}

}
