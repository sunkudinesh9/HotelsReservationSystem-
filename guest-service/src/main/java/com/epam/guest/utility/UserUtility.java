package com.epam.guest.utility;

import java.util.ArrayList;
import java.util.List;

import com.epam.guest.entity.CreditCard;
import com.epam.guest.entity.Profile;
import com.epam.guest.entity.User;
import com.epam.guest.model.CreditCardDto;
import com.epam.guest.model.ProfileDto;
import com.epam.guest.model.UserDto;

public class UserUtility {
	public User convertUserDtoToUser(UserDto userDto) {
		User user = new User();

		// Converting from model Credit card object to entity credit card object
		List<CreditCard> creditCards = new ArrayList<>();
		for (int i = 0; i < userDto.getCreditCardDto().size(); i++) {
			CreditCard creditcard = new CreditCard();
			CreditCardDto creditCardDto = userDto.getCreditCardDto().get(i);
			creditcard.setCardHolder(creditCardDto.getCardHolder());
			creditcard.setCardNumber(creditCardDto.getCardNumber());
			creditcard.setCardType(creditCardDto.getCardType());
			creditcard.setExpiryDate(creditCardDto.getExpiryDate());
			creditcard.setUser(user);
			creditCards.add(creditcard);
		}
		user.setCreditCards(creditCards);
		user.setStatus(userDto.getStatus());

		// Converting from model profile object to entity profile object
		Profile profile = new Profile();
		ProfileDto profileDto = userDto.getProfileDto();
		profile.setCity(profileDto.getCity());
		profile.setCountry(profileDto.getCountry());
		profile.setEmailid(profileDto.getEmailid());
		profile.setFirstName(profileDto.getFirstName());
		profile.setLastName(profileDto.getLastName());
		profile.setMobileNumber(profileDto.getMobileNumber());
		profile.setPinCode(profileDto.getPinCode());
		profile.setState(profileDto.getState());
		profile.setStreet(profileDto.getStreet());
		user.setProfile(profile);

		return user;
	}
}
