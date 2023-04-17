package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class SLL {
	protected DNode head;
	protected DNode tail;
	int size;

	// Unparameterized default constructor
	public SLL() {
		head = null;
		tail = null;
		size = 0;
	}

	// Overload constructor with a Node object argument to use as head
	public SLL(DNode head) {
		this.head = head;
		this.tail = head;
		this.size = 1;
	}

	public DNode getHead() {
		return head;
	}

	// TODO: CHECK
	// Inserts node object at head of the list
	public void insertHead(DNode node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.setNext(head);
			head = node;
		}
		size++;
	}

	// Inserts node object at the tail of the list
	public void insertTail(DNode node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		size++;
	}

	// Inserts node object in the specified position
	public void insert(DNode node, Integer position) throws Exception {
		DNode i = head;
		int counter = 1;

		while (counter != position && i != null) {
			i = i.getNext();
			counter++;
		}

		if (counter == position) {
			node.setNext(i);
			i.setNext(node);
			size++;
		} else {
			throw new Exception("Linked list is smaller in size than position " + position);
		}
	}

	// Insert a node in its proper position in a sorted list
	public void sortedInsert(DNode node) {
		if (head == null) {
			insertHead(node);
			return;
		}
		DNode curr;
		DNode prev;
		for (curr = head, prev = null; curr != null
				&& node.getValue() > curr.getValue(); prev = curr, curr = curr.getNext())
			;
		if (prev == null) {
			insertHead(node);
		} else {
			node.setNext(curr);
			node.setPrev(prev);
			prev.setNext(node);
			curr.setPrev(node);
			size++;
		}
	}

	// Look up a node in the list
	public DNode search(DNode node) {
		DNode current = head;
		while (current != null && current != node) {
			current = current.getNext();
		}
		return current;
	}

	public DNode search(Integer value) {
		DNode current = head;
		while (current != null) {
			if (current.value == value) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	// Delete the tail node
	public void deleteHead() throws Exception {
		if (head == null) {
			throw new Exception("Linked list is empty");
		}

		this.head = head.getNext();
		size--;
	}

	public void deleteTail() throws Exception {
		if (tail == null) {
			throw new Exception("Linked list is empty");
		}

		if (head == tail) {
			this.head = null;
			this.tail = null;
			size--;
		}

		else {
			DNode i = head;

			while (i.getNext() != tail) {
				i = i.getNext();
			}

			i.setNext(null);
			tail = i;
			size--;
		}
	}

	// checks if list is empty
	public boolean isEmpty() {
		return size == 0;
	}

	public void delete(DNode node) throws Exception {
		if (head == null) {
			return;
		}
		if (head == node) {
			head = head.getNext();
			head.setPrev(null);
			size--;
			return;
		}
		DNode curr = head;
		while (curr.getNext() != null && curr.getNext() != node) {
			curr = curr.getNext();
			if (curr.getNext() == node) {
				curr.setNext(curr.getNext().getNext());
				if (curr.getNext() != null) {
					curr.getNext().setPrev(curr);
					size--;
				}
			}
		}
	}

	public void print() {
		System.out.println("The singly linked list is of size " + size);

		DNode i = head;
		Integer value = i.getValue();
		boolean isSorted = true;
		while (i != null) {
			if (value > i.getValue()) {
				isSorted = false;
				break;
			}
			i = i.getNext();
		}
		System.out.println("Sorted list " + isSorted);
		DNode j = head;
		while (j != null) {
			System.out.println(j);
			j = j.getNext();
		}
	}

	public static void main(String[] args) throws Exception {

		// SLL test
		// Create a new singly linked list
		SLL sll = new SLL();

		// Insert nodes
		sll.insertHead(new DNode(2));
		sll.insertHead(new DNode(1));
		sll.insertTail(new DNode(4));
		sll.insertTail(new DNode(5));

		// Print the list
		sll.print();

		// Search for a node
		DNode node = sll.search(4);
		System.out.println("Searched node: " + node);

		// Delete a node
		sll.delete(node);
		System.out.println("After deleting the node: ");
		sll.print();

		// Insert a node in a sorted list
		sll.sortedInsert(new DNode(3));
		System.out.println("After sorted insert: ");
		sll.print();

		// Delete the head and tail nodes
		sll.deleteHead();
		sll.deleteTail();
		System.out.println("After deleting head and tail: ");
		sll.print();
	}
}
