package com.denis.kisina.practice.cracking_the_coding_interview;

import java.util.*;
import java.util.LinkedList;

public class Airbnb {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A,E,N,S");
        list.add("S,H,N");
        list.add("E,N");
        list.add("H");
        list.add("N");

        System.out.println(costOfModules(list));
    }

    private static List<String> costOfModules(List<String> lines) {
        List<String> result = new ArrayList<>(); //1
        Map<String, List<String>> graph = new HashMap<>();//1

        for (String line : lines) { //n being the size of list
            String[] nodes = line.split(","); //1
            graph.putIfAbsent(nodes[0], new ArrayList<>());// 1

            for (int i = nodes.length - 1; i > 0; i--) { // l length of the line
                graph.putIfAbsent(nodes[i], new ArrayList<>());//1
                List<String> listOfNeighbors = graph.get(nodes[i]);//1
                listOfNeighbors.add(nodes[0]);//1
            }
        }
        Stack<String> stack = new Stack<>();
        topologicalSortUtil(graph, new HashSet<>(), stack);

        for (String str: graph.keySet()) { //v being the vertex
            int count = 0;//1
            Set<String> visited = new HashSet<>();//1
            Queue<String> bfs = new LinkedList<>();//1
            bfs.add(str);//1
            while (!bfs.isEmpty()) {
                String node = bfs.poll();//1
                boolean notVisited = !visited.contains(node);//1
                if(notVisited) {
                    count++;//1
                    bfs.addAll(graph.get(node));//1
                    visited.add(node);
                }
            }
            result.add(str + "," + count);
        }
        Collections.sort(result);//nlogn
        return result;
    }

    private static void topologicalSortUtil(Map<String, List<String>> graph, HashSet<Object> visited, Stack<String> stack) {
        for (String  s: graph.keySet()){
        visited.add(s);

            for (String node : graph.get(s)) {
                if (!visited.contains(node)) {
                    topologicalSortUtil(graph, visited, stack);
                }
                stack.push(node);
            }
        }
    }

}
