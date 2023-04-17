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

    public Integer removeFirst() {
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

    public Integer removeLast() {
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
}
