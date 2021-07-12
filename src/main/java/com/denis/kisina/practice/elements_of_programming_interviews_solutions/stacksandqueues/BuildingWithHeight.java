package com.denis.kisina.practice.elements_of_programming_interviews_solutions.stacksandqueues;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class  BuildingWithHeight {
    public Integer id;
    public Integer height;

    public BuildingWithHeight(Integer id, Integer height) {
        this.id = id;
        this.height = height;
    }

    public static Deque<BuildingWithHeight> examineBuildingWithSunset(Iterator<Integer> sequence){
        int buildingIndex = 0;

        Deque<BuildingWithHeight> buildingsWithSunset = new LinkedList<>();
        while(sequence.hasNext()){
            Integer buildingHeight = sequence.next();
            while(!buildingsWithSunset.isEmpty() && (Integer.compare(buildingHeight, buildingsWithSunset.getLast().height ) >= 0)){
                buildingsWithSunset.removeLast();
            }
            buildingsWithSunset.addLast(new BuildingWithHeight(buildingIndex++, buildingHeight));
        }
        return buildingsWithSunset;
    }
}
