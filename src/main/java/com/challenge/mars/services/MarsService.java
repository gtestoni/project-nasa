package com.challenge.mars.services;

import org.springframework.stereotype.Service;

import com.challenge.mars.exception.MarsException;
import com.challenge.mars.model.Coordinate;
import com.challenge.mars.model.Robot;

@Service
public class MarsService {

	public String sendCoordinates(String coordinate) throws MarsException {
		if (coordinate == null) {
			throw new MarsException("The coordinate can't be null");
		}

		char[] commands = coordinate.toCharArray();

		Robot robot = new Robot().createInstance();

		for (int i = 0; i < commands.length; i++) {
			try {
				Coordinate.valueOf(commands[i]).prepareAction(robot);
				validateRobotPosition(robot);
			} catch (NullPointerException e) {
				throw new MarsException("Invalid command");
			}
		}
		return robot.toString();
	}

	private void validateRobotPosition(Robot robot) throws MarsException {
		validatePositionY(robot);
		validatePositionX(robot);
	}

	private void validatePositionY(Robot robot) throws MarsException {
		if (robot.getPositionY() < 0 || robot.getPositionY() > 5) {
			throw new MarsException("Invalid position Y");
		}
	}

	private void validatePositionX(Robot robot) throws MarsException {
		if (robot.getPositionX() < 0 || robot.getPositionX() > 5) {
			throw new MarsException("Invalid position X");
		}
	}
}
