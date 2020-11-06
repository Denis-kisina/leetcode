package com.denis.kisina.practice;

import java.util.HashMap;
import java.util.Objects;

public class AddTwoNumbers {



        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//         i will loop through the numbers moving starting from the last to firt

//      incase when i add the numbers and i get more than 10, i take the last number and add it to the next number
//         i will store the number in a list

            // then return the list
            ListNode fake = new ListNode(0);
            ListNode p = fake;
            HashMap<Character, Integer> map = new HashMap<>();
            map.getOrDefault(1,1);

            ListNode head = null;
            int carry = 0, sum;

            while(l1 != null || l2 != null){
                sum = carry + (l1 != null ? l1.val: 0) + (l2 != null? l2.val:0);

                carry = (sum > 9)?1:0;

                head = new ListNode(sum > 9? sum%10: sum );
                p.next = head;
                p = p.next;
                System.out.print(head);
                l1 = l1.next;
                l2 = l2.next;

                if(carry > 0){
                    ListNode l = new ListNode(carry);
                    p.next = l;
                }

            }




            return fake.next;

        }






}
