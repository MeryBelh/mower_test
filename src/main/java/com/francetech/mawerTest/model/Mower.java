package com.francetech.mawerTest.model;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import com.francetech.mawerTest.model.enumeration.Instruction;
import com.francetech.mawerTest.model.enumeration.Orientation;


public class Mower implements IMove<Mower>{

	
	private Position position;
	
	private Orientation orientation;
	
	List<Instruction> instructions;
	

	public Mower() {
		super();
	}
	
	public Mower(final int x, final int y, final Orientation orientation) {
		super();
		this.orientation = orientation;
		position = new Position(x,y);
		instructions = new ArrayList<>();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}
	
	

	public Mower executeInstruction(Instruction instructionsToExecute) {
		instructionsToExecute.apply(this);
		return this;
	}

	@Override
	public Mower turnRight() {
		this.setOrientation(orientation.right());
		return this;
	}

	@Override
	public Mower turnLeft() {
		this.setOrientation(orientation.left());
		return this;
	}

	@Override
	public Mower moveForward() {

		switch (orientation) {
		case E:
			this.setPosition(position.incrementX());
			break;
		case S:
			this.setPosition(position.decrementY());
			break;
		case N:
			this.setPosition(position.incrementY());
			break;
		case W:
			this.setPosition(position.decrementX());
			break;
		}
			return this;
	}

	 public String getLocation() {
	        return format("(%s, %s, %s)", position.getX(), position.getY(), orientation);
	    }
	
}
