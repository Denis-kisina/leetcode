package com.denis.kisina.practice;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class IslandCount {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}
        };

        System.out.println(numIslands(grid));
        checkPossibility(new int[]{5, 7, 1, 8});
    }

    private static int islandCount = 0;
    private Set<String> explored = new HashSet<>();

    public static int numIslands(char[][] grid) {

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    ++islandCount;
                    grid[r][c] = '0';
                    explore(r, c, grid);
                }
            }
        }

        return islandCount;
    }

    private static void explore(int r, int c, char[][] grid) {
        Queue<String> q = new ArrayDeque<>();
        q.offer(r + "," + c);

        while (!q.isEmpty()) {
            String pts = q.poll();
            String[] pt = pts.split(",");
            int row = Integer.parseInt(String.valueOf(pt[0]));
            int col = Integer.parseInt(String.valueOf(pt[1]));
            pts = "";
            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                q.offer((row - 1) + "," + col);
                grid[row - 1][col] = '0';
            }

            if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                q.offer((row + 1) + "," + col);
                grid[row + 1][col] = '0';
            }

            if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
                q.offer(row + "," + (col + 1));
                grid[row][col + 1] = '0';
            }

            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                q.offer(row + "," + (col - 1));
                grid[row][col - 1] = '0';
            }
        }
    }

//[5,7,1,8]

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                nums[i - 1] = nums[i] - 1;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
