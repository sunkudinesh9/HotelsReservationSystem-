package com.epam.hotel.util;

import org.springframework.stereotype.Component;

import com.epam.hotel.entity.Hotel;
import com.epam.hotel.model.HotelDto;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
@Component
public class HotelUtility implements Converter{

	JMapper<Hotel,HotelDto> jMapper;

	public HotelUtility() {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(Hotel.class));
		
		jMapper = new JMapper<>(Hotel.class, HotelDto.class, api);
	}

	@Override
	public Hotel convert(HotelDto hotelDto) {
		return jMapper.getDestination(hotelDto);
	}
}
