package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MinimumCostForTicketsTest extends TestCase {
    MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();

    @Test
    public void testCase1(){
        int expected = 11;

        int[] days = {1,4,6,7,8,20};
        int[] cost = {2,7,15};

        Assert.assertEquals(expected, minimumCostForTickets.mincostTickets(days, cost));
    }

}