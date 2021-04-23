package com.epam.guest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.guest.model.User;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.utility.MarshelUtility;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;

	public com.epam.guest.entity.User addUser(User user) {
		return guestRepository.save(new MarshelUtility().convertUser(user));
	}

	public List<com.epam.guest.entity.User> getUsers() {
		return guestRepository.findByStatus(true);
	}

	public com.epam.guest.entity.User getUserById(int userId) {
		Optional<com.epam.guest.entity.User> optionalUser = guestRepository.findById(userId);
		com.epam.guest.entity.User user = new com.epam.guest.entity.User();
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
		}
		return user;
	}

	public String updateUser(User user, int userId) {
		return "User updated";
	}

	public String deleteUser(int userId) {
		guestRepository.deleteById(userId);
		return "deleted";
	}
}
