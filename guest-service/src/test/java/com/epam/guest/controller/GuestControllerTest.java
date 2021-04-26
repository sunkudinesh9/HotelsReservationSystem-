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

import com.epam.guest.entity.User;
import com.epam.guest.model.ProfileDto;
import com.epam.guest.model.UserDto;
import com.epam.guest.service.GuestService;
import com.epam.guest.utility.UserUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GuestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private UserUtility userUtility;

	@MockBean
	private GuestService guestService;

	private UserDto userDto;

	@BeforeEach
	void beforeEach() {
		userUtility = new UserUtility();
		userDto = new UserDto();
		userDto.setStatus(true);
		userDto.setCreditCards(new ArrayList<>());
		userDto.setProfile(new ProfileDto());
	}

	@Test
	void addUserTest() throws Exception {
		String userDtoJson = objectMapper.writeValueAsString(userDto);

		Mockito.when(guestService.addUser(userDto)).thenReturn(userUtility.convert(userDto));

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/users").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(userDtoJson)).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void getUserByIdTest() throws Exception {

		Mockito.when(guestService.getUserById(ArgumentMatchers.anyInt()))
				.thenReturn(userUtility.convert(userDto));

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/users/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getUserTest() throws Exception {

		UserDto userDto = new UserDto();
		userDto.setStatus(true);
		userDto.setCreditCards(new ArrayList<>());
		userDto.setProfile(new ProfileDto());

		List<User> users = new ArrayList<>();
		users.add(userUtility.convert(userDto));

		Mockito.when(guestService.getUsers()).thenReturn(users);

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/users")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void updateUserTest() throws Exception {

		String userDtoJson = objectMapper.writeValueAsString(userDto);

		Mockito.when(guestService.updateUser(ArgumentMatchers.any(UserDto.class), ArgumentMatchers.anyInt()))
				.thenReturn(userUtility.convert(userDto));

		mockMvc.perform(MockMvcRequestBuilders.put("/v1/api/users/1").contentType(MediaType.APPLICATION_JSON)
				.content(userDtoJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void deleteUser() throws Exception {

		Mockito.when(guestService.deleteUser(ArgumentMatchers.anyInt())).thenReturn("Deleted");

		mockMvc.perform(MockMvcRequestBuilders.delete("/v1/api/users/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
