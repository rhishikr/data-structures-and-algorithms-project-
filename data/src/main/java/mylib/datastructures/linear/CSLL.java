package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CSLL extends SLL {
	private DNode tail;

	// Unparameterized default constructor
	public CSLL() {
		super();
		tail = null;
	}

	// Overload constructor with a Node object argument to use as head
	public CSLL(DNode head) {
		super(head);
		head.setNext(head);
		tail = head;
	}

	// Inserts node object at head of the list
	public void insertHead(DNode node) {
		if (isEmpty()) {
			head = node;
			tail = node;
			node.setNext(node);
		} else {
			node.setNext(head);
			head = node;
			tail.setNext(head);
		}
		size++;
	}

	// Inserts node object at the tail of the list
	public void insertTail(int data) {
		DNode newNode = new DNode(data);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			DNode current = head;
			while (current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
		}
	}

	// Inserts node object in the specified position
	public void insert(DNode node, Integer position) throws Exception {
		if (position < 1 || position > size + 1) {
			throw new Exception("Position out of range");
		}
		if (position == 1) {
			insertHead(node);
		} else if (position == size + 1) {
			insertTail(node);
		} else {
			DNode current = head;
			for (int i = 1; i < position - 1; i++) {
				current = current.getNext();
			}
			node.setNext(current.getNext());
			current.setNext(node);
			size++;
		}
	}

	// Deletes the head of the list
	public void deleteHead() throws Exception {
		if (isEmpty()) {
			throw new Exception("Linked list is empty");
		}
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.getNext();
			tail.setNext(head);
		}
		size--;
	}

	// Deletes the tail of the list
	public void deleteTail() throws Exception {
		if (isEmpty()) {
			throw new Exception("Linked list is empty");
		}
		if (size == 1) {
			deleteHead();
		} else {
			DNode current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			current.setNext(head);
			tail = current;
			size--;
		}
	}

	// Deletes the specified node from the list
	public void delete(DNode node) throws Exception {
		if (isEmpty()) {
			return;
		}
		if (head == node) {
			deleteHead();
			return;
		}
		DNode current = head.getNext();
		DNode previous = head;
		while (current != head) {
			if (current == node) {
				previous.setNext(current.getNext());
				size--;
				return;
			}
			previous = current;
			current = current.getNext();
		}
		throw new Exception("Node not found in the list");
	}

	// Prints the elements in the list
	public void print() {
		if (head == null) {
			System.out.println("Circular Singly Linked List is empty");
			return;
		}
		DNode current = head;
		System.out.print("Circular Singly Linked List: ");
		do {
			System.out.print(current.value + " ");
			current = current.next;
		} while (current != head);
		System.out.println();
	}

	// CSLL test
	public static void main(String[] args) throws Exception {
		// Creating an empty list
		CSLL list = new CSLL();
		list.print(); // Output: Circular Singly Linked List is empty

		// Adding nodes to the list
		DNode node1 = new DNode(1);
		DNode node2 = new DNode(2);
		DNode node3 = new DNode(3);
		list.insertHead(node1);
		list.insertHead(node2);
		list.insertTail(4);
		list.print(); // Output: Circular Singly Linked List: 2 1 3

		// Deleting nodes from the list
		list.delete(node2);
		list.deleteTail();
		list.print(); // Output: Circular Singly Linked List: 1

		// Inserting a node at a specific position
		DNode node4 = new DNode(4);
		list.insert(node4, 1);
		list.print(); // Output: Circular Singly Linked List: 1 4

		// Deleting the head of the list
		list.deleteHead();
		list.print(); // Output: Circular Singly Linked List: 4
	}
}
