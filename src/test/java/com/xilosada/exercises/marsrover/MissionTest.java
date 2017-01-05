package com.xilosada.exercises.marsrover;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.xilosada.exercises.marsrover.Order.L;
import static com.xilosada.exercises.marsrover.Order.M;
import static com.xilosada.exercises.marsrover.Order.R;
import static com.xilosada.exercises.marsrover.Position.Orientation.E;
import static com.xilosada.exercises.marsrover.Position.Orientation.N;
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
public class MissionTest {

    @Test public void calculateFinalPosition() throws Exception {
        Plateau plateau = Plateau.createPlateau(3, 3);
        List<Order> orders = Arrays.asList(M, L, M, L, M, L, M);
        Position deployPosition = Position.createPosition(N, 0, 0);
        Mission mission = Mission.createMission(plateau, orders, deployPosition);

        Position finalPosition = mission.calculateFinalPosition();

        assertEquals(0, finalPosition.getX());
        assertEquals(0, finalPosition.getY());
        assertEquals(E, finalPosition.getOrientation());
    }

    @Test public void shouldSolveFirstExample() {
        Plateau plateau = Plateau.createPlateau(5, 5);
        List<Order> orders = Arrays.asList(L, M, L, M, L, M, L, M, M);
        Position deployPosition = Position.createPosition(N, 1, 2);
        Mission mission = Mission.createMission(plateau, orders, deployPosition);

        Position finalPosition = mission.calculateFinalPosition();

        assertEquals(1, finalPosition.getX());
        assertEquals(3, finalPosition.getY());
        assertEquals(N, finalPosition.getOrientation());
    }


    @Test public void shouldSolveSecondExample() {
        Plateau plateau = Plateau.createPlateau(5, 5);
        List<Order> orders = Arrays.asList(M, M, R, M, M, R, M, R, R, M);
        Position deployPosition = Position.createPosition(E, 3, 3);
        Mission mission = Mission.createMission(plateau, orders, deployPosition);

        Position finalPosition = mission.calculateFinalPosition();

        assertEquals(5, finalPosition.getX());
        assertEquals(1, finalPosition.getY());
        assertEquals(E, finalPosition.getOrientation());
    }

}