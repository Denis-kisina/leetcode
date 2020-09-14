package com.denis.kisina.practice;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceBST {

    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;


        List<Integer> list = new ArrayList<>();

        inOrderTraversal(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            minDiff = Math.min(minDiff, Math.abs(list.get(i + 1) - list.get(i)));
        }
        return minDiff;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }


}
