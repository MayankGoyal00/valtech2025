package com.valtech.training.restapis.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OwnerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Test
	void test() throws Exception {
		ResultActions result =mockMvc.perform(get("/api/v1/owners/{id}",3));
		result.andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(3))
		.andExpect(jsonPath("$.name").value("MITUL"))
		.andExpect(jsonPath("$.mobile").value("9887654321"));
	}

}
