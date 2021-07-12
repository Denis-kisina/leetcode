package com.denis.kisina.practice.binarytrees;

import lombok.AllArgsConstructor;

import static com.denis.kisina.practice.elements_of_programming_interviews_solutions.stacksandqueues.BinaryTree.BinaryTreeNode;

@AllArgsConstructor
public class BalancedStatusWithHeight {

    public boolean balanced;
    public int height;

    public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
        return checkBalanced(tree).balanced;
    }

    private static BalancedStatusWithHeight checkBalanced(BinaryTreeNode<Integer> tree) {

        if(tree == null) {
            return new BalancedStatusWithHeight(true, -1);
        }

        BalancedStatusWithHeight leftResult = checkBalanced(tree.left);

        if(!leftResult.balanced) {
            return leftResult;
        }

        BalancedStatusWithHeight rightResult = checkBalanced(tree.right);

        if(!rightResult.balanced) {
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalancedStatusWithHeight(isBalanced, height);
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    private static boolean checkSymmetric(BinaryTreeNode<Integer> subTree0, BinaryTreeNode<Integer> subTree1) {
        if(subTree0 == null && subTree1 == null) {
            return true;
        } else if( subTree0 != null && subTree1 != null) {
            return subTree0.data == subTree1.data
                    && checkSymmetric(subTree0.left, subTree1.right)
                    && checkSymmetric(subTree0.right, subTree1.left);
        }

        return false;
    }
}
