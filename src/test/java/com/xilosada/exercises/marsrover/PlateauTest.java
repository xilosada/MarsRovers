package com.xilosada.exercises.marsrover;

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
public class PlateauTest {

    @Test public void shouldCreateARectangularPlateau() throws Exception {
        Plateau plateau = Plateau.createPlateau(2, 3);

        assertEquals(2, plateau.getSizeX());
        assertEquals(3, plateau.getSizeY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenCreatingANegativeXSizePlateau() throws Exception {
        Plateau.createPlateau(-1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenCreatingANegativeYSizePlateau() throws Exception {
        Plateau.createPlateau(1, -3);
    }

}