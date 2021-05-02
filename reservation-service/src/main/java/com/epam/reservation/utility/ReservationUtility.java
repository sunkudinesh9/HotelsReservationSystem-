package com.epam.reservation.utility;


import com.epam.reservation.entity.Reservation;
import com.epam.reservation.model.ReservationDto;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

public class ReservationUtility implements Converter{
	JMapper<Reservation,ReservationDto> jMapper;

	public ReservationUtility() {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(Reservation.class));
		
		jMapper = new JMapper<>(Reservation.class, ReservationDto.class, api);
	}

	@Override
	public Reservation convert(ReservationDto reservationDto) {
		return jMapper.getDestination(reservationDto);
	}

}
