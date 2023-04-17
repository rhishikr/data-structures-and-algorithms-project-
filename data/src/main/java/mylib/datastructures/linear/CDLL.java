package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {
	private DNode tail;

	public CDLL() {
		super();
		tail.setNext(getHead());
		getHead().setPrev(tail);
	}

	public CDLL(DNode node) {
		super(node);
		tail.setNext(getHead());
		getHead().setPrev(tail);
		getHead().setNext(tail);
		tail.setPrev(getHead());
	}

	@Override
	public void addFirst(int value) {
		super.addFirst(value);
		getHead().setPrev(tail);
		tail.setNext(getHead());
	}

	@Override
	public void addLast(int value) {
		super.addLast(value);
		tail.setNext(getHead());
		getHead().setPrev(tail);
	}

	@Override
	public Integer deleteFirst() {
		Integer removedValue = super.deleteFirst();
		tail.setNext(getHead());
		getHead().setPrev(tail);
		return removedValue;
	}

	@Override
	public Integer deleteLast() {
		Integer removedValue = super.deleteLast();
		tail.setNext(getHead());
		getHead().setPrev(tail);
		return removedValue;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		DNode current = getHead();
		sb.append("[");
		while (current != tail) {
			sb.append(current.toString());
			sb.append(" <-> ");
			current = current.getNext();
		}
		sb.append(tail.toString());
		sb.append(" <-> ");
		sb.append(getHead().toString());
		sb.append("]");
		return sb.toString();
	}

	// CDLL test
	public static void main(String[] args) {
		CDLL cdll = new CDLL();
		System.out.println("CDLL is empty: " + cdll.isEmpty()); // true

		cdll.addFirst(2);
		cdll.addFirst(1);
		cdll.addLast(3);
		cdll.addLast(4);
		System.out.println(cdll.toString()); // [1 <-> 2 <-> 3 <-> 4 <-> 1]

		cdll.deleteFirst();
		System.out.println(cdll.toString()); // [2 <-> 3 <-> 4 <-> 2]

		cdll.deleteLast();
		System.out.println(cdll.toString()); // [2 <-> 3 <-> 2]

		cdll.deleteFirst();
		cdll.deleteLast();
		System.out.println(cdll.toString()); // [3]

		cdll.deleteFirst();
		System.out.println(cdll.toString()); // []

		System.out.println("CDLL is empty: " + cdll.isEmpty()); // true
	}
}
