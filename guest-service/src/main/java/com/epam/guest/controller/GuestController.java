package com.epam.guest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.guest.entity.User;
import com.epam.guest.model.ApiResponse;
import com.epam.guest.model.UserDto;

@RequestMapping("/v1/api")
public interface GuestController {
	@PostMapping("/users")
	public ResponseEntity<ApiResponse<User>> addUser(@RequestBody UserDto userDto);

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers();

	@GetMapping("/users/{userid}")
	public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable int userid);

	@PutMapping("/users/{userid}")
	public ResponseEntity<ApiResponse<User>> updateUser(@RequestBody UserDto userDto, @PathVariable int userid);

	@DeleteMapping("/users/{userid}")
	public ResponseEntity<ApiResponse<User>> deleteUserById(@PathVariable int userid);

	@GetMapping("/users/username/{username}")
	public ResponseEntity<ApiResponse<User>> getUserByUserName(@PathVariable String username);

}
