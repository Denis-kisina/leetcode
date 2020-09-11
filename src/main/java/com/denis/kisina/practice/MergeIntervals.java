package com.denis.kisina.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;


public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a, b) -> Integer.compare( a[0], b[0]));

//      create a new list to hold new arrays intervals pairs
        LinkedList<int[]> listArrays = new LinkedList<>();


        for(int[] arr: intervals){

            if(listArrays.isEmpty() || listArrays.getLast()[1] < arr[0]){
                listArrays.add(arr);
            }else{
                listArrays.getLast()[1] = Math.max(listArrays.getLast()[1],arr[1] );

            }
        }

//        iterate through the sort array
//        int i = 0;

//        while(i < intervals.length){
//            if(i == intervals.length-1){
//                listArrays.add(new int[]{intervals[i][0], intervals[i][1]});
//                break;
//            }
//            if(intervals[i][1] < intervals[i+1][0]){
//                listArrays.add(new int[]{intervals[i][0], intervals[i][1]});
//                i++;
//            }else{
//                if(intervals[i][1] > intervals[i+1][1]){
//                    listArrays.add(new int[]{intervals[i][0], intervals[i][1]});
//                }else{
//                    listArrays.add(new int[]{intervals[i][0], intervals[i+1][1]});
//                }
//                i += 2;
//            }
//
//        }


//        new array to return
//        int[][] newArray = new int[listArrays.size()][];
//
//        for (int j = 0; j < listArrays.size(); j++) {
//            newArray[j] = listArrays.get(j);
//        }

        return listArrays.toArray(new int[listArrays.size()][]);
    }
}



















