package com.xilosada.exercises;

import com.xilosada.exercises.marsrover.Mission;
import com.xilosada.exercises.marsrover.Position;

import java.io.IOException;

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
public class Main {

    public static void main(String... args) {
        try {
            MissionInput input = new MissionFileReader(args[0]).getInput();
            solveExercise(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solveExercise(MissionInput input) {

        Position position1 = Mission.createMission(input.getPlateauSize(),
                input.getRover1Orders(),
                input.getRover1DeployPoint())
                .calculateFinalPosition();

        Position position2 = Mission.createMission(input.getPlateauSize(),
                input.getRover2Orders(),
                input.getRover2DeployPoint())
                .calculateFinalPosition();

        new MissionOutput(position1,position2)
                .printResult();
    }

}
