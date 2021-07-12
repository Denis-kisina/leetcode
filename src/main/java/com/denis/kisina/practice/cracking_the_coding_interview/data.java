package com.denis.kisina.practice.cracking_the_coding_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class data {

    /*
    A, E, N, S

    A -> E
    A -> N
    A -> S

    E -> A
    N -> A
    S -> A
    A ->


    map<, []>

    [A, E, N, S]
    map<A, []>
    map<S, [A]>
    map<N, [A]>
    map[E, [A]]
    map<A, []>

    [S,H,N]
    map<S, [A]>
    map<N, [A, S]>, map<H, [S]>, map[S, [A, S]]

    [E,N]
    map<E, [A]>
    map<N, [A, S, E]>, map<E, [A, E]>

    [H]
    map<H, [S]>
    map<H, [S, H]>

    [N]
    map<N, [A,S,E]>
    map<N, [A,S,E,N]>

     */
    /*

    5
A,E,N,S
S,H,N
E,N
H
N


package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("A,E,N,S");
        test.add("S,H,N");
        test.add("E,N");
        test.add("H");
        test.add("N");

        System.out.println(costOfNodes(test));
    }

    /**
     * initially
     * a -> e
     * a -> n
     * a -> s
     *
     * reverse
     *
     * S -> A
     * N -> A
     * E -> A
     * A
     *
     * [ a , e]
     * [ a, n]
     * [ a, s]
     *
     *  Map.put(a, list[e,n,s])
     *
     *  after meeting A,E,N,S
     *  map<e,[a])
     *  map<n,[a])
     *  map<s,[a])
     *  map<a,[])
     *
     *  S,H,N
     *  map<e,[a])
     *  map<h, [s])
     *  map<n, [a,s])
     *  map<s,[a])
     *  map<a,[])
     *
     *




    static List<String> costOfNodes(List<String> lines) {
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> graph = new HashMap<>();
        for (String line : lines) {
            String[] nodes = line.split(",");
            graph.putIfAbsent(nodes[0], new ArrayList<String>());
            // A, E, N, S
            // 0  1  2  3
            for (int i = nodes.length - 1; i > 0; i--) {
                graph.putIfAbsent(nodes[i], new ArrayList<String>());
                List<String> listOfNeighbors = graph.get(nodes[i]);
                listOfNeighbors.add(nodes[0]);
            }
        }


        // q: [n], c:0, v:[]
        // 1st iteration, deque n
        // c: 1, q:[s,e], v: [n]
        // 2nd it, deque s
        // c: 2, q:[e,a] , v: [n,s]
        // 3rd it, deque e
        // c: 3, q: [a,a], v: [ n,s,e]
        // 4th it, deque a
        // c: 4, q: [a], v : [n, s, e,a]
        // 5th it, deque a
        // c: 4, q: [], v: [n,s,e,a]




        for (String s : graph.keySet()) {
            int count = 0;
            Set<String> visited = new HashSet<>();
            Queue<String> bfs = new LinkedList<>();
            bfs.add(s);
            while (!bfs.isEmpty()) {
                String node = bfs.poll();
                boolean notVisited = !visited.contains(node);
                if(notVisited) {
                    count++;
                    bfs.addAll(graph.get(node));
                    visited.add(node);
                }
            }
            result.add(s + "," + count);
        }

        Collections.sort(result); // n log(n) time & log(n) space
        return result;
    }
}
*/

}
