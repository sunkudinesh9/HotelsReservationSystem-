package com.epam.guest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.guest.model.CreditCard;
import com.epam.guest.model.Profile;
import com.epam.guest.model.User;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.utility.MarshelUtility;

class GuestServiceTest {

	@Mock
	private GuestRepository guestRepository;

	@InjectMocks
	private GuestService guestService;

	private MarshelUtility marshelUtility;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		marshelUtility = new MarshelUtility();
	}

	@Test
	void addUserTest() {
		User user = new User();
		user.setStatus(true);

		List<CreditCard> listOdCrediCards = new ArrayList<>();
		listOdCrediCards.add(new CreditCard(1234567890L, "12/23", "Dinesh", "Visa"));
		user.setCreditCard(listOdCrediCards);
		user.setProfile(new Profile());
		com.epam.guest.entity.User userEntityData = marshelUtility.convertUser(user);
		Mockito.when(guestRepository.save(userEntityData)).thenReturn(userEntityData);
		com.epam.guest.entity.User userEntity = guestService.addUser(user);

		Assertions.assertAll(() -> assertNotNull(userEntity),
				() -> assertEquals(userEntity.getStatus(), user.getStatus()));

	}

	@Test
	void getUsersTest() {
		User user = new User();
		user.setStatus(true);

		List<CreditCard> listOdCrediCards = new ArrayList<>();
		listOdCrediCards.add(new CreditCard(1234567890L, "12/23", "Dinesh", "Visa"));
		user.setCreditCard(listOdCrediCards);
		user.setProfile(new Profile());

		List<com.epam.guest.entity.User> listOfUsersData = new ArrayList<>();
		listOfUsersData.add(marshelUtility.convertUser(user));

		Mockito.when(guestService.getUsers()).thenReturn(listOfUsersData);
		List<com.epam.guest.entity.User> listOfUsers = guestService.getUsers();
		Assertions.assertNotNull(listOfUsers);
		Assertions.assertTrue(listOfUsers.size() > 0);

	}

	@Test
	void getUserById() {
		User user = new User();
		user.setStatus(true);

		List<CreditCard> listOdCrediCards = new ArrayList<>();
		listOdCrediCards.add(new CreditCard(1234567890L, "12/23", "Dinesh", "Visa"));
		user.setCreditCard(listOdCrediCards);
		user.setProfile(new Profile());
		com.epam.guest.entity.User userEntityData = marshelUtility.convertUser(user);
		Optional<com.epam.guest.entity.User> optionalUserEntityData = Optional.of(userEntityData);
		Mockito.when(guestRepository.findById(ArgumentMatchers.anyInt())).thenReturn(optionalUserEntityData);

		com.epam.guest.entity.User userEntity = guestService.getUserById(1);

		Assertions.assertAll(() -> assertNotNull(userEntity),
				() -> assertEquals(userEntity.getStatus(), user.getStatus()));
	}

}
