package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;


public class MinimumAbsoluteDifferenceBSTTest extends TestCase {

    MinimumAbsoluteDifferenceBST minimumAbsoluteDifferenceBST = new MinimumAbsoluteDifferenceBST();


    public void testGetMinimumDifference() {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(3));
        treeNode.right.left = new TreeNode(2);
        Assert.assertEquals(1, minimumAbsoluteDifferenceBST.getMinimumDifference(treeNode));
    }

    public void testGetMinimumDifference1() {
        TreeNode treeNode = new TreeNode(5, new TreeNode(4), new TreeNode(7));
//        treeNode.right.left = new TreeNode(2);
        Assert.assertEquals(1, minimumAbsoluteDifferenceBST.getMinimumDifference(treeNode));
    }
}