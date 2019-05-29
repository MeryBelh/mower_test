package com.francetech.mawerTest.model.enumeration;

import com.francetech.mawerTest.model.IMove;

public enum Instruction {

	F {
		@Override
		public <T extends IMove<T>> T apply(IMove<T> move) {

			return move.moveForward();
		}
	},
	R {
		@Override
		public <T extends IMove<T>> T apply(IMove<T> move) {

			return move.turnRight();
		}
	},
	L {
		@Override
		public <T extends IMove<T>> T apply(IMove<T> move) {

			return move.turnLeft();
		}
	};

	  
	public abstract <T extends IMove<T>> T apply(IMove<T> move);
}
