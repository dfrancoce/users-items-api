package com.dfc.users.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = UsersItemsApiApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UsersItemsApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}

