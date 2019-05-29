package com.francetech.mawerTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.francetech.mawerTest.model.Mower;
import com.francetech.mawerTest.model.enumeration.Orientation;

@RunWith(MockitoJUnitRunner.class)
public class MowerServiceImplTest {
	

    @Test
    public void should_turn_left() {
        testTurnLeft(Orientation.N, Orientation.W);
        testTurnLeft(Orientation.W, Orientation.S);
        testTurnLeft(Orientation.S, Orientation.E);
        testTurnLeft(Orientation.E, Orientation.N);
    }

    @Test
    public void should_turn_right() {
        testTurnRight(Orientation.W, Orientation.N);
        testTurnRight(Orientation.S, Orientation.W);
        testTurnRight(Orientation.E, Orientation.S);
        testTurnRight(Orientation.N, Orientation.E);
    }

    @Test
    public void should_move_forward() {
        testMoveForwardWhenNorth();
        testMoveForwardWhenSouth();
        testMoveForwardWhenEast();
        testMoveForwardWhenWest();
    }
    
    
    private void testTurnLeft(final Orientation initial, final Orientation expected) {
        //Given
        Mower mower = new Mower(5, 5, initial);

        //Action
        Mower newMower = mower.turnLeft();

        //Asserts
        assertThat(expected).isEqualTo(newMower.getOrientation());
    }
    
    
    private void testTurnRight(final Orientation initial, final Orientation expected) {
        //Given
        Mower mower = new Mower(5, 5, initial);

        //Action
        Mower newMower = mower.turnRight();

        //Asserts
        assertThat(expected).isSameAs(newMower.getOrientation());
    }

    private void testMoveForward(final Mower mower, int expectedX, int expectedY) {
        //Action
        Mower newMower = mower.moveForward();

        //Asserts
        assertThat(expectedX).isEqualTo(newMower.getPosition().getX());
        assertThat(expectedY).isEqualTo(newMower.getPosition().getY());
    }
    
    
    private void testMoveForwardWhenNorth() {
        //Given
        Mower mower = new Mower(5, 5, Orientation.N);

        //Test
        testMoveForward(mower, 5, 6);
    }

    private void testMoveForwardWhenSouth() {
        //Given
        Mower mower = new Mower(5, 5, Orientation.S);

        //Test
        testMoveForward(mower, 5, 4);
    }

    private void testMoveForwardWhenEast() {
        //Given
        Mower mower = new Mower(5, 5, Orientation.E);

        //Test
        testMoveForward(mower, 6, 5);
    }

    private void testMoveForwardWhenWest() {
        //Given
        Mower mower = new Mower(5, 5, Orientation.W);

        //Test
        testMoveForward(mower, 4, 5);
    }


}
