package com.epam.guest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.epam.guest.dto.CreditCardDto;
import com.epam.guest.dto.ProfileDto;
import com.epam.guest.dto.UserDto;
import com.epam.guest.entity.User;

@SpringBootTest
class GuestApplicationTest {

	private UserDto userDto;

	@Autowired
	private RestTemplate restTemplate;

	@BeforeEach
	void beforeEach() {
		userDto = new UserDto();
		userDto.setStatus(true);
		userDto.setUserName("Sunkudinesh9");
		userDto.setPassword("test");
		List<CreditCardDto> creditCards = new ArrayList<>();
		creditCards.add(new CreditCardDto(1,1234567890, "12/24", "Sunku Dinesh Kumar", "Visa"));
		userDto.setCreditCards(creditCards);
		userDto.setProfile(new ProfileDto(1,"Dinesh kumar", "Sunku", "sunku.dinesh9@gmail.com", 9176060361L,
				"Gandhi katta", "Tadipatri", "Andhra Pradesh", 515411, "India"));
	}

	@Test
	void addUserTest() throws Exception {
		ResponseEntity<User> userDetails = restTemplate.postForEntity("http://localhost:8081/v1/api/users", userDto,
				User.class);
		User user = userDetails.getBody();
		Assertions.assertNotNull(user);
		Assertions.assertAll(() -> Assertions.assertEquals(1234567890, user.getCreditCards().get(0).getCardNumber()),
				() -> Assertions.assertEquals("12/24", user.getCreditCards().get(0).getExpiryDate()),
				() -> Assertions.assertEquals("Sunku Dinesh Kumar", user.getCreditCards().get(0).getCardHolder()),
				() -> Assertions.assertEquals("Visa", user.getCreditCards().get(0).getCardType()));
	}
}
