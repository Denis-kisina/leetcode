package com.denis.kisina.practice.elements_of_programming_interviews_solutions.stacksandqueues;

import java.util.*;

/**
 * BinaryTreeNode represents a node in a binary tree with a left and
 * right child.
 * @author D kisina
 * @version 1.0 11/7/2020
 */

public class BinaryTree {

    BinaryTreeNode<Integer> root;


    private BinaryTreeNode<Integer> addRecursive(BinaryTreeNode current, Integer value ){

        if(current == null){
            return new BinaryTreeNode<>(value);
        }
        if(value < current.data){
            current.left = addRecursive(current.left, value);
        }else if(value > current.data){
            current.right = addRecursive(current.right, value);
        }else{
            return current;
        }
    }

    public void add(int value){
        root = addRecursive(root, value);
    }

    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree){

        Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        currDepthNodes.add(tree);

        while(!currDepthNodes.isEmpty()){
            Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<>();
            List<Integer> thisLevel = new ArrayList<>();
            while(!currDepthNodes.isEmpty()){
                BinaryTreeNode<Integer> curr = currDepthNodes.poll();
                if(curr != null){
                    thisLevel.add(curr.data);

                    nextDepthNodes.add(curr.left);
                    nextDepthNodes.add(curr.right);
                }
            }
            if(!thisLevel.isEmpty()){
                result.add(thisLevel);
            }
            currDepthNodes = nextDepthNodes;
        }
        return result;


    }

    class BinaryTreeNode<I extends Number>{
        I data;
        BinaryTreeNode<I> left, right;

        public BinaryTreeNode(I data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
