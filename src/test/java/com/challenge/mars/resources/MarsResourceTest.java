package com.challenge.mars.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsResourceTest {

	private MockMvc mockMvc;

	@Autowired
	private MarsResource resource;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}

	@Test
	public void shouldSendSuccessCommand() throws Exception {
		mockMvc.perform(post("/rest/mars/MMRMMRMM").contentType(MediaType.TEXT_PLAIN_VALUE)).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnError() throws Exception {
		mockMvc.perform(post("/rest/mars/FFF").contentType(MediaType.TEXT_PLAIN_VALUE)).andExpect(status().isBadRequest());
	}

}
