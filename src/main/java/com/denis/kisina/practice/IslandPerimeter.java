package com.denis.kisina.practice;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {

        int count = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0){return count;}
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    count += 4;
                    if(row > 0 && grid[row-1][col] == 1){
                        count -=2;
                    }
                    if(col > 0 && grid[row][col-1] == 1){
                        count -=2;
                    }
//                    count = checkWater(grid, element, row, col, count);

                }
            }
        }
         /*
        Input: grid = [[0,1,0,0],
                       [1,1,1,0],
                       [0,1,0,0],
                       [1,1,0,0]]
        */

        return count;
    }

    public int checkWater(int[][] grid, int element, int row, int col, int count) {

        if (row >= grid.length  || col >= grid[0].length) {
            count++;
        }

//         checkWater(grid, element, row-1, col, count);
//         checkWater(grid, element, row+1, col, count);
//         checkWater(grid, element, row, col-1, count);
//         checkWater(grid, element, row, col+1, count);


        if (grid[row][col-1] == 0) {
            count++;
        }

        if (grid[row][col + 1] == 0) {
            count++;
        }

        if (grid[row-1][col] == 0) {
            count++;
        }

        if (grid[row+1][col + 1] == 0) {
            count++;
        }
        return count;
    }
}
