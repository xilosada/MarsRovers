package com.xilosada.exercises;

import com.xilosada.exercises.marsrover.Order;
import com.xilosada.exercises.marsrover.Plateau;
import com.xilosada.exercises.marsrover.Position;
import com.xilosada.exercises.marsrover.Position.Orientation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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
public class MissionFileReader implements MissionReader {


    private final String path;

    public MissionFileReader(String path) {
        this.path = path;
    }

    @Override
    public MissionInput getInput() throws IOException {
        List<String> lines= Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
        return parseLines(lines);
    }

    private MissionInput parseLines(List<String> lines) {
        Plateau plateauSize = getPlateau(cleanedString(lines.get(0)));
        Position rover1Position = getInitialPosition(cleanedString(lines.get(1)));
        List<Order> rover1Orders = getOrdersFromString(cleanedString(lines.get(2)));
        Position rover2Position  = getInitialPosition(cleanedString(lines.get(3)));
        List<Order> rover2Orders = getOrdersFromString(cleanedString(lines.get(4)));

        return new MissionInput(plateauSize, rover1Position, rover1Orders, rover2Position, rover2Orders);
    }

    private String cleanedString(String string) {
        return string.substring(string.indexOf(": ")+2);
    }

    private Position getInitialPosition(String input) {
        String[] results = input.split(" ");

        int x = Integer.valueOf(results[0]);
        int y = Integer.valueOf(results[1]);
        Orientation orientation = getOrientationFromString(results[2]);

        return Position.createPosition(orientation, x ,y);
    }

    private Plateau getPlateau(String input) {
        int separatorIndex = input.indexOf("x");
        int x = Integer.valueOf(input.substring(0, separatorIndex));
        int y = Integer.valueOf(input.substring(separatorIndex + 1));
        return Plateau.createPlateau(x, y);
    }

    private Orientation getOrientationFromString(String orientationString) {
        return Orientation.valueOf(orientationString);
    }

    private List<Order> getOrdersFromString(String orientationString) {
       return orientationString.chars()
                .mapToObj(this::getOrder)
                .collect(Collectors.toList());
    }

    private Order getOrder(int letter) {
        switch (letter) {
            case 'M':
                return Order.M;
            case 'R':
                return Order.R;
            case 'L':
                return Order.L;
            default:
                throw new IllegalArgumentException();
        }
    }

}
