package com.epam.guest.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

import com.epam.guest.model.User;
import com.epam.guest.service.GuestService;
import com.epam.guest.utility.MarshelUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GuestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private MarshelUtility marshelUtility;

	@MockBean
	private GuestService guestServiceClass;

	@BeforeEach
	void beforeEach() {
		marshelUtility = new MarshelUtility();
	}

	@Test
	void addUserTest() throws Exception {
		User user = new User();
		user.setStatus(true);

		String uerData = objectMapper.writeValueAsString(user);

		Mockito.when(guestServiceClass.addUser(user)).thenReturn(marshelUtility.convertUser(user));

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/users").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(uerData)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getUserByIdTest() throws Exception {

		User user = new User();
		user.setStatus(true);

		Mockito.when(guestServiceClass.getUserById(ArgumentMatchers.anyInt()))
				.thenReturn(marshelUtility.convertUser(user));

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/users/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getUserTest() throws Exception {

		User user = new User();
		user.setStatus(true);

		List<com.epam.guest.entity.User> listOfUsers = new ArrayList<>();
		listOfUsers.add(marshelUtility.convertUser(user));

		Mockito.when(guestServiceClass.getUsers()).thenReturn(listOfUsers);

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/users")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void updateUserTest() throws Exception {

		User user = new User();
		user.setStatus(true);
		String uerData = objectMapper.writeValueAsString(user);

		Mockito.when(guestServiceClass.updateUser(ArgumentMatchers.any(User.class), ArgumentMatchers.anyInt()))
				.thenReturn("Dinesh");

		mockMvc.perform(
				MockMvcRequestBuilders.put("/v1/api/users/1").contentType(MediaType.APPLICATION_JSON).content(uerData))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void deleteUser() throws Exception {

		Mockito.when(guestServiceClass.deleteUser(ArgumentMatchers.anyInt())).thenReturn("Deleted");

		mockMvc.perform(MockMvcRequestBuilders.delete("/v1/api/users/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
