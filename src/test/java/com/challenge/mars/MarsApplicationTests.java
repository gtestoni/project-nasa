package com.challenge.mars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsApplicationTests {

	@Test
	public void contextLoads() {
		MarsApplication.main(new String[] { "--spring.main.web-environment=false" });
	}
}
