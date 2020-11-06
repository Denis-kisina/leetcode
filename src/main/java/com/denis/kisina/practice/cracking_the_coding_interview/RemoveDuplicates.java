package com.denis.kisina.practice.cracking_the_coding_interview;

import java.util.HashSet;
import java.util.Objects;

/*
      Definition for the singly linked list
     */
class Node {
    int value;
    Node next;


    public Node(int value) {
        this(value, null);
    }
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node() {

    }

    public void print() {
        Node last = next;
        while(last != null){
            System.out.print(last.value + "->");
            last = last.next;
        }
//            System.out.print(value + "->");
    }

    public void addNodeLast(int val) {

        Node newLink = new Node(val);
        if (isEmpty()) {
            next = newLink;
        }else{
            Node last = next;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newLink;
        }
    }

    private boolean isEmpty() {
        return next == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}

class LinkedList {
    private Node first;

    public LinkedList() {
        this.first = null;
    }

    public LinkedList(Node first) {
        this.first = first;

    }

    public void addNodeLast(int val) {

        Node newLink = new Node(val);
        if (isEmpty()) {
            first = newLink;
        }else{
            Node last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newLink;
        }
    }
    public void printList() {
        System.out.print("List (first-->last):");
        Node curr = first;
        while(first != null){
            first.print();
            first = first.next;
        }
    }


    public boolean isEmpty(){
        return first == null;
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();

//        list.addNodeLast(1);
//        list.addNodeLast(2);
//        list.addNodeLast(3);
//        list.addNodeLast(3);
//        list.addNodeLast(4);
//        list.addNodeLast(4);
//        list.addNodeLast(5);

//        list.printList();


        Node node = new Node();

        node.addNodeLast(1);
        node.addNodeLast(1);
        node.addNodeLast(1
        );
        node.addNodeLast(3);



        node.print();

        deleteDuplicates(node);
        node.print();
    }

    //using a hashset
    public static void deleteDuplicates(Node n) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;

        while (n != null) {
            if (set.contains(n.value)) {
                previous.next = n.next;
            } else {
                set.add(n.value);
                previous = n;
            }
            n = n.next;
        }
    }
}
