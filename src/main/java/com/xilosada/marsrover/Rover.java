package com.xilosada.marsrover;

import com.xilosada.marsrover.Position.Orientation;

import static com.xilosada.marsrover.Position.createPosition;
import static com.xilosada.marsrover.Position.createPositionSameLocation;

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
public class Rover implements SpaceVehicle{

    public Rover() {}

    public Position move(Position position) {
        switch (position.getOrientation()) {
            case N:
                return createPosition(Orientation.N, position.getX(), position.getY() + 1);
            case E:
                return createPosition(Orientation.E, position.getX() + 1, position.getY());
            case S:
                return createPosition(Orientation.S, position.getX(), position.getY() - 1);
            case W:
                return createPosition(Orientation.W, position.getX() - 1, position.getY());
            default:
                throw new InvalidOrientationException();
        }
    }

    public Position turnLeft(Position position) {
        switch (position.getOrientation()) {
            case N:
                return createPositionSameLocation(position, Orientation.W);
            case E:
                return createPositionSameLocation(position, Orientation.N);
            case S:
                return createPositionSameLocation(position, Orientation.E);
            case W:
                return createPositionSameLocation(position, Orientation.S);
            default:
                throw new InvalidOrientationException();
        }
    }

    public Position turnRight(Position position) {
        switch (position.getOrientation()) {
            case N:
                return createPositionSameLocation(position, Orientation.E);
            case E:
                return createPositionSameLocation(position, Orientation.S);
            case S:
                return createPositionSameLocation(position, Orientation.W);
            case W:
                return createPositionSameLocation(position, Orientation.N);
            default:
                throw new InvalidOrientationException();
        }
    }

    private static class InvalidOrientationException extends UnsupportedOperationException {

        public InvalidOrientationException() {
            super("Invalid orientation");
        }
    }
}
