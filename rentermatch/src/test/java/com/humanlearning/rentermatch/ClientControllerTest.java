package com.humanlearning.rentermatch;

import com.humanlearning.rentermatch.mapper.ClientMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@SpringBootTest(classes = {RentermatchApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ClientControllerTest {

	@Resource
	private MockMvc mockMvc;

	@Test
	@DisplayName("Empty Email Login")
	public void testMock1() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/login")
						.param("email","")
						.param("password",""))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
				.andReturn();
	}

	@Test
	@DisplayName("Empty Password Login")
	public void testMock2() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/login")
						.param("email","kevinceltics09@hotmail.com")
						.param("password",""))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("password cannot be empty"))
				.andReturn();
	}

	@Test
	@DisplayName("Wrong Password Login")
	public void testMock3() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/login")
						.param("email","kevinceltics09@hotmail.com")
						.param("password","1234"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("wrong password"))
				.andReturn();
	}

	@Test
	@DisplayName("Correct Password Login")
	public void testMock4() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/login")
						.param("email","kevinceltics09@hotmail.com")
						.param("password","123"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("login successfully"))
				.andReturn();
	}

	@Test
	@DisplayName("Empty Email Register")
	public void testMock5() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/register")
						.param("name","Lena Smith")
						.param("password","123")
						.param("email",""))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
				.andReturn();
	}

	@Test
	@DisplayName("Empty Password Register")
	public void testMock6() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/register")
						.param("name","Lena Smith")
						.param("password","")
						.param("email","kevinceltics09@hotmail.com"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("password cannot be empty"))
				.andReturn();
	}

	@Test
	@DisplayName("Empty Name Register")
	public void testMock7() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/register")
						.param("name","")
						.param("password","123")
						.param("email","kevinceltics09@hotmail.com"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("name cannot be empty"))
				.andReturn();
	}

	@Test
	@DisplayName("Duplicate User Register")
	public void testMock8() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/client/register")
						.param("name","Lena Smith")
						.param("password","123")
						.param("email","kevinceltics09@hotmail.com"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("register failed, user already exist"))
				.andReturn();
	}
}
