package com.challenge.mars.model;

public class Robot {

	private int positionX;

	private int positionY;

	private char orientation;

	public Robot() {
	}

	Robot(int positionX, int positionY, char orientation) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientation = orientation;
	}

	public Robot createInstance() {
		return new Robot(0, 0, 'N');
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public char getOrientation() {
		return orientation;
	}

	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	public String toString() {
		return "(" + this.getPositionX() + ", " + this.getPositionY() + ", " + this.getOrientation() + ")";
	}

}
