package com.epam.hotel.util;

import com.epam.hotel.entity.Hotel;
import com.epam.hotel.model.HotelDto;

public interface Converter {
   public Hotel convert(HotelDto userDto);
}