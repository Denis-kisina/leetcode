package com.denis.kisina.practice.elements_of_programming_interviews_solutions.stacksandqueues;

import java.util.*;

public class Stack {
    //stores (element, cachedMaximum) pair
    private Deque<ElementWithCachedMax> elementWithCachedMaxes = new LinkedList<>();

    public boolean empty() {
        return elementWithCachedMaxes.isEmpty();
    }

    public Integer max() {
        if(empty())
            throw new IllegalStateException("max(): empty() stack");
        return elementWithCachedMaxes.getFirst().max;
    }

    public Integer pop() {
        if(empty())
            throw new IllegalStateException("pop(): empty() stack");
        return elementWithCachedMaxes.removeFirst().element;
    }

    public void push(Integer x) {
        elementWithCachedMaxes.addFirst(new ElementWithCachedMax(x, Math.max(x, empty() ? x: max())));
    }
}
