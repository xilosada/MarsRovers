package com.xilosada.exercises.marsrover;

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
                return Position.createPosition(Position.Orientation.N, position.getX(), position.getY() + 1);
            case E:
                return Position.createPosition(Position.Orientation.E, position.getX() + 1, position.getY());
            case S:
                return Position.createPosition(Position.Orientation.S, position.getX(), position.getY() - 1);
            case W:
                return Position.createPosition(Position.Orientation.W, position.getX() - 1, position.getY());
            default:
                throw new InvalidOrientationException();
        }
    }

    public Position turnLeft(Position position) {
        switch (position.getOrientation()) {
            case N:
                return Position.createPositionSameLocation(position, Position.Orientation.W);
            case E:
                return Position.createPositionSameLocation(position, Position.Orientation.N);
            case S:
                return Position.createPositionSameLocation(position, Position.Orientation.E);
            case W:
                return Position.createPositionSameLocation(position, Position.Orientation.S);
            default:
                throw new InvalidOrientationException();
        }
    }

    public Position turnRight(Position position) {
        switch (position.getOrientation()) {
            case N:
                return Position.createPositionSameLocation(position, Position.Orientation.E);
            case E:
                return Position.createPositionSameLocation(position, Position.Orientation.S);
            case S:
                return Position.createPositionSameLocation(position, Position.Orientation.W);
            case W:
                return Position.createPositionSameLocation(position, Position.Orientation.N);
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
