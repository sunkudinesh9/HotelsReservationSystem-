package com.epam.hotel.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
	private T data;
	private HttpStatus httpStatus;
	private String message;

}