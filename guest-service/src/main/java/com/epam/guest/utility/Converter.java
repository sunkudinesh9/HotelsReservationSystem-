package com.epam.guest.utility;

import com.epam.guest.entity.User;
import com.epam.guest.model.UserDto;

public interface Converter {
   public User convert(UserDto userDto);
}