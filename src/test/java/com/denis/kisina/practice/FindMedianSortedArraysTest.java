package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class FindMedianSortedArraysTest extends TestCase {

    FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();

    public void testFindMedianSortedArrays() {
int[] nums1 = {1,2};
int[] nums2 = {3,4};

        Assert.assertEquals(2.50000, findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}