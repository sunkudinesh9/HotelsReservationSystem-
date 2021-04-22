package com.epam.guest.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.epam.guest.model.CreditCard;
import com.epam.guest.model.StayHistory;
import com.epam.guest.model.User;
import com.epam.guest.service.GuestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GuestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private GuestService guestServiceClass;

	@Test
	void addUserTest() throws Exception {
		User user = new User();
		user.setId(1);
		user.setActive(true);
		user.setStatus("Active");

		String uerData = objectMapper.writeValueAsString(user);

		Mockito.when(guestServiceClass.addUser(user)).thenReturn(user);
		System.out.println("ResponseEntity: " + guestServiceClass.addUser(user).getId());

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/users").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(uerData)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getUserByIdTest() throws Exception {

		User user = new User();
		user.setId(1);
		user.setActive(true);
		user.setStatus("Active");

		Mockito.when(guestServiceClass.getUserById(ArgumentMatchers.anyInt())).thenReturn(user);

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/users/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getUserTest() throws Exception {

		User user = new User();
		user.setId(1);
		user.setActive(true);
		user.setStatus("Active");

		List<User> listOfUsers = new ArrayList<>();
		listOfUsers.add(user);

		Mockito.when(guestServiceClass.getUsers()).thenReturn(listOfUsers);

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/users")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
