package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class IslandPerimeterTest extends TestCase {

    IslandPerimeter l = new IslandPerimeter();

    public void testIslandPerimeter() {

        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};

        Assert.assertEquals(16, l.islandPerimeter(grid));
    }
}