package com.denis.kisina.practice;

import java.util.*;
import java.util.function.IntFunction;


/*

/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1's. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
    0  1  2  3. 4  5  6
  0[0, 1, 1, 1, 1, 1, 1],
  1[1, 1, 1, 1, 1, 1, 1],
  2[0, 1, 1, 0, 0, 0, 1],
  3[1, 0, 1, 0, 0, 0, 1],
  4[1, 0, 1, 1, 1, 1, 1],
  5[1, 0, 1, 0, 0, 1, 1],
  6[1, 1, 1, 0, 0, 1, 1],
  7[1, 1, 1, 1, 1, 1, 0],
]
11111
10001
10001
11111

  for i <- 0


Sample output variations (only one is necessary):

findRectangles(image1) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],
    [[2,0],[2,0]],
    [[2,3],[3,5]],
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]
  // (using top-left-x-y and width/height):
  [
    [[0,0],[1,1]],
    [[0,2],[1,1]],
    [[3,2],[3,2]],
    [[1,3],[1,3]],
    [[3,5],[2,2]],
    [[6,7],[1,1]],
  ]

Other test cases:

image2 = [
  [0],
]

findRectangles(image2) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],
  ]

  // (using top-left-x-y and width/height):
  [
    [[0,0],[1,1]],
  ]

image3 = [
  [1],
]

findRectangles(image3) => []

image4 = [
  [1, 1, 1, 1, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1],
]

findRectangles(image4) =>
  // (using top-left-row-column and bottom-right or top-left-x-y and width/height):
  [
    [[1,1],[3,3]],
  ]

n: number of rows in the input image
m: number of columns in the input image


 */

public class FindRectangles {
    public static void main(String[] argv) {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };

        int[][] image4 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };

        System.out.println(new FindRectangles().findRectangles(image1));
    }

    public Integer[][] findRectangles(int[][] image) {


        List<List<Integer>> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[i].length; j++) {
                int temp = image[i][j];
                if (temp == 0) {
                    List<Integer> temp_result = new ArrayList<>();
                    String array_top = i + "," + j;
                    temp_result.add(i);
                    temp_result.add(j);

                    queue.add(array_top);
                    result.add(temp_result);

                    bfs(image, queue, result);

                }
            }
        Integer[][] final_result = new Integer[result.size()][];
        int i = 0;

        for (List<Integer> list : result) {
            final_result[i++] = list.toArray(new Integer[list.size()]);

        }

        for (Integer[] l: final_result)
            System.out.println(Arrays.toString(l));
        return final_result;
    }


    private void bfs(int[][] image, Queue<String> queue, List<List<Integer>> result) {

        List<Integer> temp2 = new ArrayList<>();

        int max_row = Integer.MIN_VALUE;
        int max_col = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            String temp = queue.remove();

            int row = Integer.parseInt(temp.split(",")[0]);
            int col = Integer.parseInt(temp.split(",")[1]);


            visit(row, col, image);

            if (row + 1 <= image.length && image[row + 1][col] == 0 && !queue.contains((row + 1) + "," + col)) {
                queue.add((row + 1) + "," + col);
            }
            if (col + 1 <= image[row].length && image[row][col + 1] == 0 && !queue.contains(row + "," + (col + 1))) {
                queue.add(row + "," + (col + 1));
            }
            if (row + 1 <= image.length && col + 1 <= image[row].length && image[row + 1][col + 1] == 0 && !queue.contains((row + 1) + "," + (col + 1))) {
                queue.add((row + 1) + "," + (col + 1));
            }
            max_row = row > max_row ? row : max_row;
            max_col = col > max_col ? col : max_col;

        }
        List<Integer> temp_result = new ArrayList<>();
        temp_result.add(max_row);
        temp_result.add(max_col);
        result.add(temp_result);
    }

    private void visit(int i, int i1, int[][] image) {
        image[i][i1] = -1;
    }

}