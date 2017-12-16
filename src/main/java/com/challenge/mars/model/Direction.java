package com.challenge.mars.model;

import java.util.HashMap;
import java.util.Map;

import com.challenge.mars.exception.MarsException;

public enum Direction {
	ROTATE_TO_WEST_FROM_NORTH('N', 'L') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('W');
		}
	},
	ROTATE_TO_EAST_FROM_NORTH('N', 'R') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('E');
		}
	},
	MOVE_NORTH('N', 'M') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setPositionY(robot.getPositionY() + 1);
		}
	},
	ROTATE_TO_EAST_FROM_SOUTH('S', 'L') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('E');
		}
	},
	ROTATE_TO_WEST_FROM_SOUTH('S', 'R') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('W');
		}
	},
	MOVE_SOUTH('S', 'M') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setPositionY(robot.getPositionY() - 1);
		}
	},
	ROTATE_TO_NORTH_FROM_EAST('E', 'L') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('N');
		}
	},
	ROTATE_TO_SOUTH_FROM_EAST('E', 'R') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('S');
		}
	},
	MOVE_EAST('E', 'M') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setPositionX(robot.getPositionX() + 1);
		}
	},
	ROTATE_TO_SOUTH_FROM_WEST('W', 'L') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('S');
		}
	},
	ROTATE_TO_NORTH_FROM_WEST('W', 'R') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setOrientation('N');
		}
	},
	MOVE_WEST('W', 'M') {
		@Override
		public void executeAction(Robot robot) throws MarsException {
			robot.setPositionX(robot.getPositionX() - 1);
		}
	};

	private static Map<String, Direction> map = new HashMap<>();

	static {
		for (Direction direction : Direction.values()) {
			map.put((direction.command + "" + direction.coordinateCommand), direction);
		}
	}

	private char command;

	private char coordinateCommand;

	public abstract void executeAction(Robot robot) throws MarsException;

	private Direction(char command, char direction) {
		this.command = command;
		this.coordinateCommand = direction;
	}

	public static Direction getDirections(String command) {
		return map.get(command);
	}

}
