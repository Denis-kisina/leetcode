package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class JumpingOnCloudsTest extends TestCase {

    JumpingOnClouds jumpingOnClouds = new JumpingOnClouds();

    public void testJumpingOnClouds() {
        int expected = 4;
        Assert.assertEquals(expected, jumpingOnClouds.jumpingOnClouds(new int[] {0,0,1,0,0,1,0}));

    }

    public void testJumpingOnClouds2() {
        int expected = 3;
        Assert.assertEquals(expected, jumpingOnClouds.jumpingOnClouds(new int[] {0,1,0,0,0,1,0}));

    }
}