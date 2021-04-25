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

import com.epam.guest.entity.User;
import com.epam.guest.model.CreditCardDto;
import com.epam.guest.model.ProfileDto;
import com.epam.guest.model.UserDto;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.utility.UserUtility;

class GuestServiceTest {

	@Mock
	private GuestRepository guestRepository;

	@InjectMocks
	private GuestService guestService;

	private UserUtility userUtility;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		userUtility = new UserUtility();
	}

	@Test
	void addUserTest() {
		UserDto userDto = new UserDto();
		userDto.setStatus(true);

		List<CreditCardDto> creditCards = new ArrayList<>();
		creditCards.add(new CreditCardDto(1234567890L, "12/23", "Dinesh", "Visa"));
		userDto.setCreditCardDto(creditCards);
		userDto.setProfileDto(new ProfileDto());
		User user = userUtility.convertUserDtoToUser(userDto);
		Mockito.when(guestRepository.save(user)).thenReturn(user);
		User userEntity = guestService.addUser(userDto);

		Assertions.assertAll(() -> assertNotNull(userEntity),
				() -> assertEquals(userEntity.getStatus(), userDto.getStatus()));

	}

	@Test
	void getUsersTest() {
		UserDto userDto = new UserDto();
		userDto.setStatus(true);

		List<CreditCardDto> creditCards = new ArrayList<>();
		creditCards.add(new CreditCardDto(1234567890L, "12/23", "Dinesh", "Visa"));
		userDto.setCreditCardDto(creditCards);
		userDto.setProfileDto(new ProfileDto());

		List<User> users = new ArrayList<>();
		users.add(userUtility.convertUserDtoToUser(userDto));

		Mockito.when(guestRepository.findAll()).thenReturn(users);
		
		List<User> actualUsers = guestService.getUsers();
		Assertions.assertNotNull(actualUsers);
		Assertions.assertTrue(actualUsers.size() > 0);

	}

	@Test
	void getUserById() {
		UserDto userDto = new UserDto();
		userDto.setStatus(true);

		List<CreditCardDto> creditCards = new ArrayList<>();
		creditCards.add(new CreditCardDto(1234567890L, "12/23", "Dinesh", "Visa"));
		userDto.setCreditCardDto(creditCards);
		userDto.setProfileDto(new ProfileDto());
		User user = userUtility.convertUserDtoToUser(userDto);
		Optional<User> optionalUser = Optional.of(user);
		Mockito.when(guestRepository.findById(ArgumentMatchers.anyInt())).thenReturn(optionalUser);

		User userEntity = guestService.getUserById(1);

		Assertions.assertAll(() -> assertNotNull(userEntity),
				() -> assertEquals(userEntity.getStatus(), userDto.getStatus()));
	}

}
