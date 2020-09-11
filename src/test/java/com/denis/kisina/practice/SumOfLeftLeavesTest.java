package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SumOfLeftLeavesTest extends TestCase {

    SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();

    @Test
    public void testSumOfLeftLeaves() {
        int expected = 24;
//[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        Assert.assertEquals(expected, sumOfLeftLeaves.sumOfLeftLeaves(root));
    }
}