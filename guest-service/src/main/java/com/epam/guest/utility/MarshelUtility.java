package com.epam.guest.utility;

import java.util.ArrayList;
import java.util.List;

import com.epam.guest.entity.CreditCard;
import com.epam.guest.model.Profile;
import com.epam.guest.model.User;

public class MarshelUtility {
	public com.epam.guest.entity.User convertUser(User user) {
		com.epam.guest.entity.User userEntity = new com.epam.guest.entity.User();

		// Converting from model Credit card object to entity credit card object
		List<CreditCard> listOfCreditCardEntity = new ArrayList<>();
		for (int i = 0; i < user.getCreditCard().size(); i++) {
			CreditCard creditcardEntity = new CreditCard();
			com.epam.guest.model.CreditCard creditCard = user.getCreditCard().get(i);
			creditcardEntity.setCadrHolderName(creditCard.getCadrHolderName());
			creditcardEntity.setCardNumber(creditCard.getCardNumber());
			creditcardEntity.setCardType(creditCard.getCardType());
			creditcardEntity.setExpairDate(creditCard.getExpairDate());
			creditcardEntity.setUser(userEntity);
			listOfCreditCardEntity.add(creditcardEntity);
		}
		userEntity.setCreditCard(listOfCreditCardEntity);
		userEntity.setStatus(user.getStatus());

		// Converting from model profile object to entity profile object
		com.epam.guest.entity.Profile profileEntity = new com.epam.guest.entity.Profile();
		Profile profile = user.getProfile();
		profileEntity.setCity(profile.getCity());
		profileEntity.setCountry(profile.getCountry());
		profileEntity.setEmailid(profile.getEmailid());
		profileEntity.setFirstName(profile.getFirstName());
		profileEntity.setLastName(profile.getLastName());
		profileEntity.setMobileNumber(profile.getMobileNumber());
		profileEntity.setPinCode(profile.getPinCode());
		profileEntity.setState(profile.getState());
		profileEntity.setStreet(profile.getStreet());
		userEntity.setProfile(profileEntity);

		return userEntity;
	}
}
