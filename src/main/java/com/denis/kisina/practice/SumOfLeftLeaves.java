package com.denis.kisina.practice;

public class SumOfLeftLeaves {


    public int sumOfLeftLeaves(TreeNode root) {

        int sumLeftLeaves = 0;

        TreeNode startLeft =  root.left;
        TreeNode startRight = root.right;

        int sumLeft = leftTraversal(startLeft, sumLeftLeaves);
        int sumright = rightTraversal(startRight, sumLeftLeaves);

        return sumLeft + sumright;
    }

    private int rightTraversal(TreeNode startRight, int sumLeftLeaves) {

        if (startRight == null)
            return sumLeftLeaves;
        System.out.println("right " + startRight.val);
//        sumLeftLeaves += startRight.val;
        rightTraversal(startRight.right, sumLeftLeaves);
        leftTraversal(startRight.left, sumLeftLeaves);

        return sumLeftLeaves;
    }

    private int leftTraversal(TreeNode startLeft, int sumLeftLeaves) {

        if (startLeft == null)
            return sumLeftLeaves;
        System.out.println("right " + startLeft.val);
        sumLeftLeaves += startLeft.val;
        rightTraversal(startLeft.right, sumLeftLeaves);
        leftTraversal(startLeft.left, sumLeftLeaves);

        return sumLeftLeaves;
    }
}


//Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return ""+val;
//
//    }
//}

