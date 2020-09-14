package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class AddTwoNumbersTest extends TestCase {
//
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    public void testAddTwoNumbers() {

        ListNode one = new ListNode(3);
        ListNode two = new ListNode(4, one);
        ListNode three = new ListNode(2, two);

        ListNode one1 = new ListNode(4);
        ListNode two1 = new ListNode(6, one1);
        ListNode three1 = new ListNode(5, two1);

        ListNode one2 = new ListNode(8);
        ListNode two2 = new ListNode(0, one2);
        ListNode three2 = new ListNode(7, two2);

        Assert.assertEquals(three2, addTwoNumbers.addTwoNumbers(three, three1));

    }

    public void testAddTwoNumbersOne() {

        /*
        *
        *
        [9]
        [9]
            *
        * expected
        * [8,1]
        *
        * */

        ListNode one = new ListNode(9);
        ListNode one1 = new ListNode(9);
        ListNode one2 = new ListNode(8);
        ListNode two2 = new ListNode(1, one2);

        Assert.assertEquals(one2, addTwoNumbers.addTwoNumbers(one, one1));

    }
}