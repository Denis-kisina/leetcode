package com.denis.kisina.practice.facebook.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.assertArrayEquals;

public class MoveZeroesTest extends TestCase {

    MoveZeroes moveZeroes = new MoveZeroes();

    public void testMoveZeroes() {
        int[] input = {0,1,0,3,12};
        int[] output = {1,3,12,0,0};

        assertArrayEquals(output, moveZeroes.moveZeroes(input));
    }
}