package com.epam.guest.utility;

import com.epam.guest.entity.User;
import com.epam.guest.model.UserDto;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

public class UserUtility implements Converter{
	JMapper<User,UserDto> jMapper;

	public UserUtility() {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(User.class));
		
		jMapper = new JMapper<>(User.class, UserDto.class, api);
	}

	@Override
	public User convert(UserDto userDto) {
		return jMapper.getDestination(userDto);
	}
}
