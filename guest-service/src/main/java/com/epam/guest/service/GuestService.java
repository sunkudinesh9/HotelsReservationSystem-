package com.epam.guest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.guest.entity.User;
import com.epam.guest.model.UserDto;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.utility.UserUtility;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;

	public User addUser(UserDto userDto) {
		return guestRepository.save(new UserUtility().convertUserDtoToUser(userDto));
	}

	public List<User> getUsers() {
		return guestRepository.findByStatus(true);
	}

	public User getUserById(int userId) {
		Optional<User> optionalUser = guestRepository.findById(userId);
		User user = new User();
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
		}
		return user;
	}

	public String updateUser(UserDto userDto, int userId) {
		return "User updated";
	}

	public String deleteUser(int userId) {
		guestRepository.deleteById(userId);
		return "deleted";
	}
}
