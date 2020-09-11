package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;



public class MergeIntervalsTest extends TestCase {

    MergeIntervals mergeIntervals = new MergeIntervals();

    public void testMerge() {

        int[][] expected = new int[][]{{1,6},{8,10},{15,18}};

        Assert.assertEquals(expected, mergeIntervals.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}}));

    }



    public void testMerge1() {

        int[][] expected = new int[][]{{0,5}};

        Assert.assertEquals(expected, mergeIntervals.merge(new int[][] {{1,4},{0,2},{3,5}}));

    }
}