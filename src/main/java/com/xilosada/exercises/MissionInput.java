package com.xilosada.exercises;

import com.xilosada.exercises.marsrover.Order;
import com.xilosada.exercises.marsrover.Position;

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
public final class MissionInput {

    private int plateauSize;

    private final Position rover1DeployPoint;
    private final List<Order> rover1Orders;

    private final Position rover2DeployPoint;
    private final List<Order> rover2Orders;

    public MissionInput(int plateauSize,
                        Position rover1DeployPoint,
                        List<Order> rover1Orders,
                        Position rover2DeployPoint,
                        List<Order> rover2Orders) {
        this.plateauSize = plateauSize;
        this.rover1DeployPoint = rover1DeployPoint;
        this.rover1Orders = rover1Orders;
        this.rover2DeployPoint = rover2DeployPoint;
        this.rover2Orders = rover2Orders;
    }

    public int getPlateauSize() {
        return plateauSize;
    }

    public Position getRover1DeployPoint() {
        return rover1DeployPoint;
    }

    public List<Order> getRover1Orders() {
        return rover1Orders;
    }

    public Position getRover2DeployPoint() {
        return rover2DeployPoint;
    }

    public List<Order> getRover2Orders() {
        return rover2Orders;
    }
}
