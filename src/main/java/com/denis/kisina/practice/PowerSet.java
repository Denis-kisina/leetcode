package com.denis.kisina.practice;
import java.util.*;

public class PowerSet {
    public static List<List<Integer>> combinations(int[] n){
        List<List<Integer>> results = new LinkedList<>();
        combinations(n, 0, results, new LinkedList<Integer>());
        return results;
    }

    private static void combinations(int[] n, int i, List<List<Integer>> results, List<Integer> paths) {
        if(i == n.length){
            results.add(paths);
            return;
        }

        List<Integer> pathWithCurrent = new LinkedList<>(paths);

        combinationsPassed(n, i +1, results, paths);

        combinationsPassed(n, i+1, results, pathWithCurrent);



    }

    private static void combinationsPassed(int[] n, int i, List<List<Integer>> results, List<Integer> paths) {
    }
}
