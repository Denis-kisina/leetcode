package com.denis.kisina.practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TowerOfHanoi {

    public static void main(String[] args) {
        computeTowerOfHanoi(3);
    }

    private static final int NUM_PEG = 3;

    public static void computeTowerOfHanoi(int numRings) {

        List<Deque<Integer>> pegs = new ArrayList<>();

        for (int i = 0; i < NUM_PEG; i++)
            pegs.add(new LinkedList<Integer>());

        for (int i = numRings; i >= 1; --i) {
            pegs.get(0).addFirst(i);
        }
        computeTowerOfHanoi(numRings, pegs, 0, 1, 2);
    }

    private static void computeTowerOfHanoi(int numRingsToMove, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {
        if(numRingsToMove > 0){
            computeTowerOfHanoi(numRingsToMove-1, pegs, fromPeg, toPeg, usePeg);
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move from peg " + fromPeg + " to peg " + toPeg);
            computeTowerOfHanoi(numRingsToMove-1, pegs, toPeg, usePeg, fromPeg);
        }
    }
}
