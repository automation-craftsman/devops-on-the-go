package com.devops;

import com.devops.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.testng.annotations.Test;

@WebMvcTest(MainController.class)
public class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testIndex() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("index.html"));
	}
}