package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class DLL {

    private DNode head;
    private DNode tail;

    public DLL() {
        head = null;
        tail = null;
    }

    public DLL(DNode node) {
        head = node;
        tail = node;
    }

    public DNode getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int value) {
        DNode newNode = new DNode(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void addLast(int value) {
        DNode newNode = new DNode(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public Integer deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Integer removedValue = head.getValue();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        return removedValue;
    }

    public Integer deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Integer removedValue = tail.getValue();
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        return removedValue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        DNode current = head;
        while (current != null) {
            sb.append(current.toString());
            if (current.getNext() != null) {
                sb.append(" <-> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    // DLL test
    public static void main(String[] args) {

        DLL dll = new DLL();
        System.out.println("Empty DLL: " + dll);

        dll.addFirst(5);
        dll.addFirst(3);
        dll.addLast(10);
        dll.addLast(15);
        System.out.println("DLL after adding nodes: " + dll);

        Integer removedFirst = dll.deleteFirst();
        Integer removedLast = dll.deleteLast();
        System.out.println("DLL after deleting first and last nodes: " + dll);
        System.out.println("Removed first node value: " + removedFirst);
        System.out.println("Removed last node value: " + removedLast);
    }
}
