package com.denis.kisina.practice.cracking_the_coding_interview;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.*;

@RequiredArgsConstructor
class MatchResults {
    private String winningTeam;
    private String losingTeam;
    private MatchResults[] test = new MatchResults[2];

    private static boolean canTeamABeatTeamB(List<MatchResults> matchResults, String teamA, String teamB) {
        Set<String> visited = new HashSet<>();
        return isReachedDFS(buildGraph(matchResults), teamA, teamB, visited);
    }

    private static boolean isReachedDFS(Map<String, Set<String>> graph, String teamA, String teamB, Set<String> visited) {

        if (teamA.equals(teamB)) {
            return true;
        } else if (visited.contains(teamA) || graph.get(teamA) == null) {
            return false;
        }

        visited.add(teamA);
        for (String team : graph.get(teamA)) {
            if (isReachedDFS(graph, team, teamB, visited)) {
                return true;
            }
        }
        return false;
    }

    private static Map<String, Set<String>> buildGraph(List<MatchResults> matchResults) {
        Map<String, Set<String>> graph = new HashMap<>();

        for (MatchResults match : matchResults) {

            Set<String> edges = graph.get(match.winningTeam);

            if (edges == null) {
                edges = new HashSet<>();
                graph.put(match.winningTeam, edges);
            }
            edges.add(match.losingTeam);
        }
        return graph;
    }

    public static List<Integer> plusOne(List<Integer> A) {
        int n = A.size() - 1;

        A.set(n, A.get(n) + 1);

        for (int i = n; i > 0 && A.get(i) == 10; --i) {
            A.set(i, 0);
            A.set(n - 1, A.get(i - 1) + 1);
        }

        if (A.get(0) == 10) {
            A.set(0, 0);
            A.add(0, 1);
        }
        return A;
    }

    public static void reverseWord(char[] input) {

        reverse(input, 0, input.length);

        int start = 0, end;

        while ((end = find(input, Character.MIN_VALUE, start)) != -1) {
            reverse(input, start, end);
            start = end + 1;
        }
        reverse(input, start, input.length);
    }

    private static void reverse(char[] input, int start, int stopIndex) {

        if (start >= stopIndex)
            return;

        int last = stopIndex - 1;
        for (int i = start; i <= start + (last - start) / 2; i++) {
            char temp = input[i];
            input[i] = input[last - i + start];
            input[last - i + start] = temp;
        }
    }

    private static int find(char[] input, char c, int start) {

        for (int i = start; i < input.length; i++) {
            if (input[i] == c)
                return i;
        }
        return -1;
    }

    /**
     * AirBNB
     *
     * @param regions
     * @param region2
     * @param region1
     * @return
     */
    public static String findSmallestRegion(List<List<String>> regions, String region2, String region1) {

        Map<String, String> childParentMap = new HashMap<>();

        for (List<String> region : regions) {
            String parent = region.get(0);
            for (int i = 1; i < region.size(); i++) {
                childParentMap.put(region.get(i), parent);
            }
        }

        Set<String> set = new HashSet<>();

        while (region1 != null) {
            set.add(region1);
            region1 = childParentMap.get(region1);
        }

        while (region2 != null) {
            if (set.contains(region2))
                return region2;
            region2 = childParentMap.get(region2);
        }
        return null;
    }

    public static void main(String[] args) {

//        List<List<String>> regions = new LinkedList<>();
//
//        List<String> region1 = new LinkedList<>();
//        region1.add("Earth");
//        region1.add("North America");
//        region1.add("South America");
//
//        List<String> region2 = new LinkedList<>();
//        region2.add("North America");
//        region2.add("United States");
//        region2.add("Canada");
//
//        List<String> region3 = new LinkedList<>();
//        region3.add("United States");
//        region3.add("New York");
//        region3.add("Boston");
//
//        List<String> region4 = new LinkedList<>();
//        region4.add("Canada");
//        region4.add("Ontario");
//        region4.add("Quebec");
//
//        List<String> region5 = new LinkedList<>();
//        region5.add("South America");
//        region5.add("Brazil");
//
//        regions.add(region1);
//        regions.add(region2);
//        regions.add(region3);
//        regions.add(region4);
//        regions.add(region5);
//
//        String r1 = "Quebec";
//        String r2 = "New York";
//        System.out.println(findSmallestRegion(regions, r1, r2));
//        addStrings("100", "0");
        //System.out.println(addBinary("11", "1"));
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 2;
      //  merge(nums1, m, nums2, n);
     //   System.out.println(nums1);

        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        validMountainArray(arr);

    }

    class Wizard implements Comparable<Wizard> {

        private int id;
        private int dist;

        public Wizard(int id) {
            this.id = id;
            this.dist = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Wizard that) {
            return this.dist - that.dist;
        }
    }

    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {

        Map<Integer, Wizard> map = new HashMap<>();
        int[] parents = new int[wizards.size()];

        for (int i = 0; i < wizards.size(); i++) {
            parents[i] = i;
            map.put(i, new Wizard(i));
        }

        map.get(source).dist = 0;

        Queue<Wizard> q = new LinkedList<>();
        q.offer(map.get(source));

        while (!q.isEmpty()) {
            Wizard curr = q.poll();
            List<Integer> neighbours = wizards.get(curr.id);
            for (int neighbour : neighbours) {
                Wizard next = map.get(neighbour);
                int weight = (int) Math.pow(next.id - curr.id, 2);

                if (curr.dist + weight < next.dist) {
                    parents[next.id] = curr.id;
                    next.dist = curr.dist + weight;
                }
                q.offer(next);
            }
        }

        List<Integer> res = new ArrayList<>();
        int t = target;
        while (t != source) {
            res.add(t);
            t = parents[t];
        }
        res.add(source);

        Collections.reverse(res);
        return res;
    }

    public static String addStrings(String num1, String num2) {
        // "0" + "0"

        // "129" + "93"
        // 2 r 1
        // 2 r 1
        int remainder = 0;

        String sb = "";

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        if (l1 < l2) {
            while (l1 >= 0) {
                int sum = (num1.charAt(l1) - '0') + (num2.charAt(l1) - '0');

                if (remainder == 1) {
                    sum += 1;
                }

                if (sum > 9) {
                    sb = sum % 10 + sb;
                    remainder = 1;
                } else {
                    sb = sum + sb;
                    remainder = 0;
                }
                l1--;
            }
        } else {
            while (l2 >= 0) {
                int sum = (num1.charAt(l2) - '0') + (num2.charAt(l2) - '0');

                if (remainder == 1) {
                    sum += 1;
                }

                if (sum > 9) {
                    sb = sum % 10 + sb;
                    remainder = 1;
                } else {
                    sb = sum + sb;
                    remainder = 0;
                }
                l2--;
            }
        }


        while (l1 >= 0) {
            sb = num1.charAt(l1) + sb;
            l1--;
        }
        while (l2 >= 0) {
            sb = num1.charAt(l2) + sb;
            l2--;
        }

        return sb;
    }

    public static String addBinary(String a, String b) {
        String sum = sumString(a, b);

        return binaryString(sum);
    }

    private static String sumString(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (l1 >= 0 || l2 >= 0) {

            int s1 = l1 >= 0 ? a.charAt(l1) - '0' : 0;
            int s2 = l2 >= 0 ? b.charAt(l2) - '0' : 0;

            int sum = (s1 + s2 + carry) % 10;
            carry = (s1 + s2 + carry) / 10;

            sb.insert(0, sum);
            l1--;
            l2--;
        }

        if (carry > 0)
            sb.insert(0, carry);
        return sb.toString();
    }

    private static String binaryString(String sum) {

        StringBuilder sb = new StringBuilder();

        int res = 0;

        for (int i = 0; i < sum.length(); i++) {
            int temp = sum.charAt(i) - '0';
            res = res * 10 + temp;
        }

        while (res > 0) {
            int remainder = res % 2;
            sb.append(remainder);
            res /= 2;
        }
        return sb.toString();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];

        int l1 = 0, l2 = 0, i = 0;

        while (l1 < nums1.length && l2 < nums2.length && i < m + n) {
            int n1 = nums1[l1];
            int n2 = nums2[l2];

            if (n1 < n2) {
                res[i] = n1;
                l1++;
            } else {
                res[i] = n2;
                l2++;
            }
            i++;
        }

        while (l1 < nums1.length && i < m + n) {
            res[i++] = nums1[l1];
            l1++;
        }

        while (l2 < nums2.length && i < m + n) {
            res[i++] = nums2[l2];
            l2++;
        }
        for (int j = 0; j < res.length; j++)
            nums1[j] = res[j];

    }

    public static boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;

        int i = 0;

        for (; i < arr.length-1 && arr[i] < arr[i+1] ; i++) {

        }

        int j = arr.length-1;

        for (; j > 0 && arr[j] < arr[j-1]; j--) {

        }

        if((i == j) && (i != 0 && j != arr.length-1))
            return true;
        else
            return false;

    }
}

