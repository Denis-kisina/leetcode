package com.denis.kisina.practice.elements_of_programming_interviews_solutions.stacksandqueues;

import java.util.*;

/**
 * BinaryTreeNode represents a node in a binary tree with a left and
 * right child.
 *
 * @author D kisina
 * @version 1.0 11/7/2020
 */

public class BinaryTree {
    public static void main(String[] args) {

    }

    BinaryTreeNode<Integer> root;


    private static BinaryTreeNode<Integer> addRecursive(BinaryTreeNode current, Integer value) {

        if (current == null) {
            return new BinaryTreeNode<Integer>(value);
        }
        if (value < (int) current.data) {
            current.left = addRecursive(current.left, value);
        } else if (value > (int) current.data) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {

        Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        currDepthNodes.add(tree);

        while (!currDepthNodes.isEmpty()) {
            Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<>();
            List<Integer> thisLevel = new ArrayList<>();
            while (!currDepthNodes.isEmpty()) {
                BinaryTreeNode<Integer> curr = currDepthNodes.poll();
                if (curr != null) {
                    thisLevel.add(curr.data);

                    nextDepthNodes.add(curr.left);
                    nextDepthNodes.add(curr.right);
                }
            }
            if (!thisLevel.isEmpty()) {
                result.add(thisLevel);
            }
            currDepthNodes = nextDepthNodes;
        }
        return result;
    }

    /*
    Binary Tree Traversals
     */

    // In Order Traversl (L->P->R)
    public static void inOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    // Post Order Traversal (L->R->P)
    public static void postOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }
    // Pre Order Traversal (P->L->R)
    public static void preOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node);
            preOrderTraversal(node);
        }
    }

    private static void visit(BinaryTreeNode node) {
        System.out.println(node.data);
    }

    public static class BinaryTreeNode<I> {
        public I data;
        public BinaryTreeNode<I> left, right;

        public BinaryTreeNode(I data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
