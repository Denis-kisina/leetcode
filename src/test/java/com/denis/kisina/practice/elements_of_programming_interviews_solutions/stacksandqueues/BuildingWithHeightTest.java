package com.denis.kisina.practice.elements_of_programming_interviews_solutions.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


import static org.junit.Assert.*;

public class BuildingWithHeightTest {

    private Deque<BuildingWithHeight> expected;
    LinkedList<Integer> sequence;

    @Test
    public void examineBuildingWithSunset() {
        expected = new LinkedList<>(Arrays.asList(new BuildingWithHeight(4,5)));
        sequence = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        test(expected, sequence);
    }

    private void test(Deque<BuildingWithHeight> expected, LinkedList<Integer> sequence) {
        Deque<BuildingWithHeight> result = BuildingWithHeight.examineBuildingWithSunset(sequence.iterator());
        expected.forEach( building -> {
            assertTrue(building.equals(result.removeFirst()));
        });
    }
}