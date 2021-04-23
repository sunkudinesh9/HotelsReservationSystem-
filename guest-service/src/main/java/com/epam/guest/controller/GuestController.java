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

import com.epam.guest.model.User;

@RequestMapping("/v1/api")
public interface GuestController {
	@PostMapping("/users")
	public ResponseEntity<com.epam.guest.entity.User> addUser(@RequestBody User user);

	@GetMapping("/users")
	public List<com.epam.guest.entity.User> getUsers();

	@GetMapping("/users/{userid}")
	public ResponseEntity<com.epam.guest.entity.User> getUserById(@PathVariable int userid);

	@PutMapping("/users/{userid}")
	public String updateUser(@RequestBody User user, @PathVariable int userid);

	@DeleteMapping("/users/{userid}")
	public String deleteUserById(@PathVariable int userid);
}
