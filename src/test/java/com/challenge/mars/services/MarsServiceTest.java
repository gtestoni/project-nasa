package com.challenge.mars.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.mars.exception.MarsException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsServiceTest {

	@Autowired
	private MarsService service;

	@Test
	public void shouldVerifyAllDirections() {
		Assert.assertEquals(service.sendCoordinates("MMRMMRMLLMLMMRRMRRML"), "(0, 2, S)");
	}

	@Test(expected = MarsException.class)
	public void shouldReturnInvalidCoordinate() {
		service.sendCoordinates("AAA");
	}

	@Test(expected = MarsException.class)
	public void shouldReturnInvalidPositionYNorth() {
		service.sendCoordinates("MMMMMMMMMMMMMMMMMMMMMMMM");
	}

	@Test(expected = MarsException.class)
	public void shouldReturnInvalidPositionYSouth() {
		service.sendCoordinates("RRMMMMMMMMMMMMMMMMMMMMMMMM");
	}

	@Test(expected = MarsException.class)
	public void shouldReturnInvalidPositionXEast() {
		service.sendCoordinates("RMMMMMMMMMMMMMMMMMMMMMMMM");
	}

	@Test(expected = MarsException.class)
	public void shouldReturnInvalidPositionXWest() {
		service.sendCoordinates("RRRMMMMMMMMMMMMMMMMMMMMMMMM");
	}

	@Test(expected = MarsException.class)
	public void shouldValidateNullCoordinate() {
		service.sendCoordinates(null);
	}
}
