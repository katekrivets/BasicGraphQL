package com.katekrivets.bootstrap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BootstrapApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertEquals(1,1);
	}

}
