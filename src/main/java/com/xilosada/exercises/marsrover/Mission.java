package com.xilosada.exercises.marsrover;

import java.util.List;

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
public class Mission {

    private final SpaceVehicle spaceVehicle;
    private final Plateau plateau;
    private final List<Order> orders;

    private Position position;

    private Mission(SpaceVehicle spaceVehicle, Plateau plateau, List<Order> orders, Position position) {
        this.spaceVehicle = spaceVehicle;
        this.plateau = plateau;
        this.orders = orders;
        this.position = position;
    }

    public static Mission createMission(Plateau plateau, List<Order> orders, Position position) {
        return new Mission(new Rover(), plateau, orders, position);
    }

    public Position calculateFinalPosition() {
        orders.forEach(this::executeOrder);
        return position;
    }

    private void executeOrder(Order order) {
        switch (order) {
            case L:
                position = spaceVehicle.turnLeft(position);
                break;
            case R:
                position = spaceVehicle.turnRight(position);
                break;
            case M:
                Position newPosition = spaceVehicle.move(position);
                if (validate(newPosition)) {
                    position = newPosition;
                }
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private boolean validate(Position moved) {
        return !(moved.getX() > plateau.getSizeX() && moved.getX() >= 0 ||
                moved.getY() > plateau.getSizeY() && moved.getY() >= 0);
    }
}
