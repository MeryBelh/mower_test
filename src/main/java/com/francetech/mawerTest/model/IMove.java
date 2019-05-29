package com.francetech.mawerTest.model;


public interface IMove<T extends IMove<T>> {

	T turnRight();

	T turnLeft();

	T moveForward();

}
