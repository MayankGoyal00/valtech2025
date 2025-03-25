//package com.valtech.training.registerservice;
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import static org.apache.http.client.methods.RequestBuilder.*;
//import static org.postgresql.core.ResultHandler.*;
//import static org.springframework.test.web.servlet.ResultMatcher.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class RegisterServiceTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void testGetUserByValidId() throws Exception {
//	    mockMvc.perform(get("/api/v1/users/1"))
//	        .andDo(print()) 
//	        .andExpect(status().isOk()) 
//	        .andExpect(content().json("{\"id\":1,\"age\":32,\"email\":\"xyz@gmail.com\",\"mobile\":8967543,\"name\":\"abdul\",\"kid\":false,\"subscriptionId\":1}"));
//	}
//	
//}
//
