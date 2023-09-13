/*
Assignment 1
AndrewTaylor_ 001092466
*/


import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SpecialLinkedList {
    static Node head;
    
    public SpecialLinkedList() {
        this.head = null;
    }
    
    public void add(int data) {
        Node new_node = new Node(data);
        if (this.head == null) {
            this.head = new_node;
            return;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;
    }
    
    public void removeDuplicates() {
        if (this.head == null) {
            return;
        }
        Node current = this.head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    
    public void reverse() {
        Node prev = null;
        Node current = this.head;
        while (current != null) {
            Node next_node = current.next;
            current.next = prev;
            prev = current;
            current = next_node;
        }
        this.head = prev;
    }
    
    public void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(" ");
    }
   
        // a function that will check if the linked list is a palindrome linked list or not.
        static boolean checkPalindrome(Node head) {
            // a pointer that will help us to traverse the linked list.
            Node currentPointer = head;
            boolean isPalindrome = true;

            // initialize a stack data structure.
            Stack<Integer> stack = new Stack<Integer>();

            // Pushing the elements of the linked list to the stack.
            while (currentPointer != null) {
                stack.push(currentPointer.data);
                currentPointer = currentPointer.next;
            }

            // Iterating the list again and checking if the top of the stack is the same as the current element or not.
            while (head != null) {
                // getting the top element for comparison.
                int i = stack.pop();


                // Checking the top element and current element are the same or not.
                if (head.data == i) {
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                    break;
                }
                head = head.next;
            }
            return isPalindrome;
        }


    public static void main(String[] args) {
        SpecialLinkedList my_list = new SpecialLinkedList();
        my_list.add(1);
        my_list.add(2);
        my_list.add(3);
        my_list.add(2);
        my_list.add(4);
        System.out.println("Original List:");
        my_list.printList();
        if (checkPalindrome(head))
            System.out.println("The linked list is a palindrome linked list.");
        else
            System.out.println("The linked list is not a palindrome linked list.");
        my_list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        my_list.printList();
        my_list.reverse();
        System.out.println("Reversed List:");
        my_list.printList();        
    }
}