package com.denis.kisina.practice;

import java.util.*;

public class PathSumIII {

    public int pathSumAlt(TreeNode root, int target) {
        LinkedList<Integer> q = new LinkedList<>();
        if (target <= 0) {
            target = target * -1;
            flipSign(root);

        }

        return pathSumAlt(root, target, 0, q, 0);
    }

    private void flipSign(TreeNode node) {
        if (node == null) {
            return;
        }

        node.val = node.val * -1;
        flipSign(node.left);
        flipSign(node.right);
    }

    private int pathSumAlt(TreeNode root, int target, int sum, LinkedList<Integer> q, int count) {
        if (root == null) {
            return count;
        }

        int value = root.val;

        q.add(value);
        sum = sum + value;

        if (sum > target) {
            int removed = q.removeFirst();
            if (removed > 0)
                sum = sum - removed;
        }

        if (value == target) {
            count++;
        }

        if ((sum == target && q.size() > 1)) {
            count++;
            sum = value;
            q = new LinkedList<Integer>();
            q.add(value);
        }

        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        q1.addAll(q);
        q2.addAll(q);

        count = pathSumAlt(root.left, target, sum, q1, count);
        count = pathSumAlt(root.right, target, sum, q2, count);
        return count;
    }

    private int pathSum2(TreeNode root, int target, int sum, LinkedList<Integer> q, int count) {
        if (root == null) {
            return count;
        }

        count = pathSumAlt(root.left, target, sum, q, count);
        count = pathSumAlt(root.right, target, sum, q, count);

        int value = root.val;

        q.add(value);
        sum = sum + value;

        if (sum > target) {
            int removed = q.removeFirst();
            sum = sum - removed;
        }

        if (sum == target && q.size() != 0) {
            count++;
            sum = 0;
            q = new LinkedList<Integer>();
        }

        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        q1.addAll(q);
        q2.addAll(q);

        return count;
    }

    public static void main(String[] args) {
        PathSumIII solution1 = new PathSumIII();
        System.out.println(solution1.pathSum(solution1.buildTree1(), 8));// 3
        System.out.println(solution1.getPaths(solution1.buildTree1()));

        System.out.println(solution1.pathSum(solution1.buildTree2(), 22));// 3
        System.out.println(solution1.pathSum(solution1.new TreeNode(1), 0));// 0
        System.out.println(solution1.pathSum(solution1.buildTree3(), -5));// 1
        System.out.println(solution1.pathSum(solution1.buildTree4(), -2));// 2
        System.out.println(solution1.pathSum(solution1.buildTree5(), 0));// 2
        System.out.println(solution1.getPaths(solution1.buildTree5()));
        System.out.println(solution1.pathSumAlt(solution1.buildTree5(), 0));
    }

    private int pathSumx(TreeNode root, int target) {
        List<List<Integer>> paths = getPaths(root);
        int count = 0;
        for (List<Integer> path : paths) {
            for (int i = 0; i < path.size(); i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum = sum + path.get(j);
                    if (sum == target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private List<List<Integer>> getPaths(TreeNode root) {

        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        getPaths(root, new ArrayList<Integer>(), paths);

        return paths;

    }

    private void getPaths(TreeNode root, List<Integer> rootSet, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }

        rootSet.add(root.val);

        if (root.left == null && root.right == null) {
            paths.add(rootSet);
            return;
        }

        getPaths(root.left, new ArrayList<>(rootSet), paths);
        getPaths(root.right, new ArrayList<>(rootSet), paths);
    }

    public int pathSum(TreeNode root, int target) {
        return pathSum(root, new ArrayList<Integer>(), 0, target);
    }

    private int pathSum(TreeNode root, List<Integer> rootSet, int count, int target) {
        if (root == null) {
            return count;
        }

        rootSet.add(root.val);
        count = checkCummulativeSum(rootSet, target, count);

        count = pathSum(root.left, new ArrayList<>(rootSet), count, target);
        count = pathSum(root.right, new ArrayList<>(rootSet), count, target);
        return count;
    }

    private int checkCummulativeSum(List<Integer> rootSet, int target, int count) {
        int sum = 0;
        for (int i = rootSet.size() - 1; i >= 0; i--) {
            sum = sum + rootSet.get(i);
            if (sum == target) {
                count++;
            }
        }

        return count;
    }

    TreeNode buildTree5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(-1);

        root.right.left = new TreeNode(5);

        return root;
    }

    private TreeNode buildTree4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        return root;
    }

    private TreeNode buildTree3() {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        return root;
    }

    TreeNode buildTree2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);

        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(1);

        return root;
    }

    private TreeNode buildTree1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}