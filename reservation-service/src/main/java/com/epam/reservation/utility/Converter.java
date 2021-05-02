package com.epam.reservation.utility;

import com.epam.reservation.entity.Reservation;
import com.epam.reservation.model.ReservationDto;

public interface Converter {
	public Reservation convert(ReservationDto reservationDto);
}
