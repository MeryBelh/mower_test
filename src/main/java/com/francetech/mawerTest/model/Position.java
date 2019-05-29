package com.francetech.mawerTest.model;

public class Position {
    
    private int x;
    private int y;

    public Position() {
		super();
	}

    
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Position incrementX() {
        return new Position(x + 1, y);
    }
    
    public Position decrementX() {
        return new Position(x - 1, y);
    }
    
    public Position incrementY() {
        return new Position(x, y + 1);
    }
    
    public Position decrementY() {
        return new Position(x, y - 1);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
