package com.valtech.training.leave.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.netflix.discovery.converters.Auto;


@SpringBootTest()
class EmployeeClientTest {

	@Autowired
	EmployeeClient client;
	@Test
	void test() {
//		assertEquals(11, client.getManager(12));
//		assertEquals(12, client.getManager(13));
		
	}

}
