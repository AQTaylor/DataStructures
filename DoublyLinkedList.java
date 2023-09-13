/*
Assignment 1
AndrewTaylor_ 001092466
*/


import java.util.*;

class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
    }

    void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    void delete(Node delNode) {
        if (head == null || delNode == null) {
            return;
        }
        if (head == delNode) {
            head = delNode.next;
        }
        if (delNode.next != null) {
            delNode.next.prev = delNode.prev;
        }
        if (delNode.prev != null) {
            delNode.prev.next = delNode.next;
        }
    }

    void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;
        }
        System.out.println(" ");
    }

    void reverse() {
        Node current = head;
        if (current == null) {
            System.out.println(" ");
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println(" ");
    }
    
    void removeDuplicates() {
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



    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAfter(dll.head, 3);
        dll.insertAtEnd(4);
        System.out.println("Original List:");
        dll.displayForward();
        System.out.println("Reversed List:");
        dll.reverse();
        dll.removeDuplicates();
        System.out.println("Duplicates Removed:");
        dll.displayForward();
        
    }
}