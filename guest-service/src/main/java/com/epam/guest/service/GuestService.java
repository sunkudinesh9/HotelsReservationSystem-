package com.epam.guest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.guest.entity.CreditCard;
import com.epam.guest.entity.User;
import com.epam.guest.exception.GuestNotFoundException;
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
		if (!optionalUser.isPresent()) {
			throw new GuestNotFoundException("Unble to find the User");
		}
		return optionalUser.get();
	}

	public User updateUser(UserDto userDto, int userId) {
		User userEntiry = new UserUtility().convertUserDtoToUser(userDto);
		User user = getUserById(userId);
		user.setProfile(userEntiry.getProfile());
		user.setStatus(userEntiry.getStatus());
		user.setStayHistory(userEntiry.getStayHistory());
		for (CreditCard card : userEntiry.getCreditCards()) {
			card.setUser(user);
		}
		user.setCreditCards(userEntiry.getCreditCards());

		return guestRepository.save(user);
	}

	public String deleteUser(int userId) {
		guestRepository.deleteById(userId);
		return "deleted";
	}
}
