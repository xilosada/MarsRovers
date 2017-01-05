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
public final class Position {

    public enum Orientation {
        N("N"), E("E"), S("S"), W("W");

        public String asString() {
            return asString;
        }

        private final String asString;

        Orientation(String asString) {
            this.asString = asString;
        }
    }

    private final Orientation orientation;
    private final int x;
    private final int y;

    private Position(Orientation orientation, int x, int y) {

        if (x < 0) throw new IllegalArgumentException("X size must be positive");
        if (y < 0) throw new IllegalArgumentException("Y size  must be positive");
        this.orientation = orientation;
        this.x = x;
        this.y = y;
    }

    public static Position createPosition(Orientation orientation, int x, int y) {
        return new Position(orientation, x, y);
    }

    public static Position createPositionSameLocation(Position position, Orientation newOrientation) {
        return new Position(newOrientation, position.getX(), position.getY());
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;
        return orientation == position.orientation;
    }

    @Override
    public int hashCode() {
        int result = orientation.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}
