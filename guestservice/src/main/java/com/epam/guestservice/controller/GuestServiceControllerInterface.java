package com.epam.guestservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.guestservice.model.User;

@RequestMapping("/v1/api")
public interface GuestServiceControllerInterface {
	@PostMapping("/users")
	public User addUser(@RequestBody User user);

	@GetMapping("/users")
	public String getUsers();

	@GetMapping("/users/{userid}")
	public String getUserById(@PathVariable int userId);

	@PutMapping("/users/{userid}")
	public String updateUser(@RequestBody User user, @PathVariable int userId);

	@DeleteMapping("/users/{userid}")
	public String deleteUser(@PathVariable int userId);
}
