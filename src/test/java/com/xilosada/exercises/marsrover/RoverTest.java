package com.xilosada.exercises.marsrover;

import com.xilosada.exercises.marsrover.Position.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xabierlosada on 05/01/17.
 * MIT License
 * <p>
 * Copyright (c) 2017 Xabier Losada
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class RoverTest {

    private Rover rover;

    @Before public void setUp() {
        rover = new Rover();
    }

    @Test public void move() throws Exception {
        Position position = Position.createPosition(Orientation.E, 0 ,1);

        Position resultPosition = rover.move(position);

        assertSameOrientation(position, resultPosition);
        assertEquals(1, resultPosition.getX());
        assertEquals(1, resultPosition.getY());


        position = Position.createPosition(Orientation.N, 0 ,1);

        resultPosition = rover.move(position);

        assertSameOrientation(position, resultPosition);
        assertEquals(0, resultPosition.getX());
        assertEquals(2, resultPosition.getY());


        position = Position.createPosition(Orientation.W, 1 ,1);

        resultPosition = rover.move(position);

        assertSameOrientation(position, resultPosition);
        assertEquals(0, resultPosition.getX());
        assertEquals(1, resultPosition.getY());


        position = Position.createPosition(Orientation.S, 0 ,1);

        resultPosition = rover.move(position);

        assertSameOrientation(position, resultPosition);
        assertEquals(0, resultPosition.getX());
        assertEquals(0, resultPosition.getY());
    }

    @Test public void turnLeft() throws Exception {
        Position position = Position.createPosition(Orientation.E, 0 ,1);

        Position resultPosition = rover.turnLeft(position);

        assertSameLocation(position, resultPosition);
        assertTrue(resultPosition.getOrientation().equals(Orientation.N));

        Position resultPosition2 = rover.turnLeft(resultPosition);

        assertSameLocation(resultPosition, resultPosition2);
        assertTrue(resultPosition2.getOrientation().equals(Orientation.W));

        Position resultPosition3 = rover.turnLeft(resultPosition2);

        assertSameLocation(resultPosition, resultPosition3);
        assertTrue(resultPosition3.getOrientation().equals(Orientation.S));

        Position resultPosition4 = rover.turnLeft(resultPosition3);

        assertSameLocation(resultPosition, resultPosition4);
        assertTrue(resultPosition4.getOrientation().equals(Orientation.E));
    }

    @Test public void turnRight() throws Exception {
        Position position = Position.createPosition(Orientation.E, 0 ,1);

        Position resultPosition = rover.turnRight(position);
        assertSameLocation(position, resultPosition);
        assertTrue(resultPosition.getOrientation().equals(Orientation.S));

        Position resultPosition2 = rover.turnRight(resultPosition);
        assertSameLocation(resultPosition, resultPosition2);
        assertTrue(resultPosition2.getOrientation().equals(Orientation.W));

        Position resultPosition3 = rover.turnRight(resultPosition2);
        assertSameLocation(resultPosition, resultPosition3);
        assertTrue(resultPosition3.getOrientation().equals(Orientation.N));

        Position resultPosition4 = rover.turnRight(resultPosition3);
        assertSameLocation(resultPosition, resultPosition4);
        assertTrue(resultPosition4.getOrientation().equals(Orientation.E));
    }

    private void assertSameLocation(Position position1, Position position2) {
        assertTrue(position1.getX() == position2.getX());
        assertTrue(position1.getY() == position2.getY());
    }

    private void assertSameOrientation(Position position1, Position position2) {
        assertTrue(position1.getOrientation() == position2.getOrientation());
    }

}