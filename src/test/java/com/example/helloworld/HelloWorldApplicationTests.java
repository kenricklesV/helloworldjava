package com.example.helloworld;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HelloWorldController.class)
class HelloWorldApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void homePage() throws Exception {
		// N.B. jsoup can be useful for asserting HTML content
		mockMvc.perform(get("/index.html")).andExpect(content().string(containsString("Get your greeting")));
	}

	@Test
	public void helloworld() throws Exception {
		mockMvc.perform(get("/helloworld")).andExpect(content().string(containsString("Hello, World, User!")));
	}

	@Test
	public void greetingWithUser() throws Exception {
		mockMvc.perform(get("/helloworld").param("name", "Greg"))
				.andExpect(content().string(containsString("Hello World, Greg!")));
	}

}
