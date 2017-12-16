package com.challenge.mars.model;

import java.util.HashMap;
import java.util.Map;

import com.challenge.mars.exception.MarsException;

public enum Coordinate {

	LEFT('L') {
		@Override
		public void prepareAction(Robot robot) throws MarsException {
			Direction.getDirections((robot.getOrientation() + "L")).executeAction(robot);
		}
	},
	RIGHT('R') {
		@Override
		public void prepareAction(Robot robot) throws MarsException {
			Direction.getDirections((robot.getOrientation() + "R")).executeAction(robot);
		}
	},
	MOVE('M') {
		@Override
		public void prepareAction(Robot robot) throws MarsException {
			Direction.getDirections((robot.getOrientation() + "M")).executeAction(robot);
		}
	};

	private static Map<Character, Coordinate> map = new HashMap<>();

	static {
		for (Coordinate coordinate : Coordinate.values()) {
			map.put(coordinate.command, coordinate);
		}
	}

	private char command;

	public abstract void prepareAction(Robot robot) throws MarsException;

	private Coordinate(char command) {
		this.command = command;
	}

	public static Coordinate valueOf(char command) {
		return map.get(command);
	}

}
