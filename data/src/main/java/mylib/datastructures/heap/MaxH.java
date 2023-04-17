package mylib.datastructures.heap;

import java.util.Vector;

public class MaxH extends Heap {

	public MaxH() {
		super();
	}

	public MaxH(Integer maxSize) {
		super(maxSize);
	}

	public MaxH(Vector<Integer> elements) {
		super(elements);
	}

	// return parent of elements[i]
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// returns left child of elements[i]
	private int left(int i) {
		return (2 * i) + 1;
	}

	// returns right child of elements[i]
	private int right(int i) {
		return (2 * i) + 2;
	}

	// heapification process after deletion
	private void heapifyDown(int i) {
		int largest = i;
		int l = left(i);
		int r = right(i);

		if (l < this.elements.size() && this.elements.get(l) > this.elements.get(largest)) {
			largest = l;
		}
		if (r < this.elements.size() && this.elements.get(r) > this.elements.get(largest)) {
			largest = r;
		}
		if (largest != i) {
			swap(i, largest);
			heapifyDown(largest);
		}
	}

	// heapification process after insertion
	private void heapifyUp(int i) {
		int p = parent(i);
		while (i > 0 && this.elements.get(i) > this.elements.get(p)) {
			swap(i, p);
			i = p;
			p = parent(i);
		}
	}

	/*
	 * takes in an array of values and returns a valid heap this can be used by
	 * sort() and the third overload constructor
	 */
	protected Vector<Integer> heapify(int[] array) {
		elements.clear();
		for (int i = 0; i < array.length; i++) {
			elements.add(array[i]);
		}
		for (int i = (elements.size() / 2) - 1; i >= 0; i--) {
			heapifyDown(i);
		}
		return elements;
	}

	// 5: inserts the value key to the vector and maintains heap properties
	public void insert(Integer key) {
		this.elements.add(key);
		heapifyUp(this.elements.size() - 1);
	}

	// 6: removes the value key from the vector and maintains heap properties
	public void delete(Integer key) {
		int index = this.elements.indexOf(key);
		if (index != -1) {
			swap(index, this.elements.size() - 1);
			this.elements.remove(this.elements.size() - 1);
			if (index < this.elements.size()) {
				heapifyDown(index);
				heapifyUp(index);
			}
		}
	}

	// 7: applies heapsort to the vector content
	public void sort() {
		for (int i = this.elements.size() - 1; i >= 1; i--) {
			swap(0, i);
			heapifyDown(0);
		}
	}

	/*
	 * 8: displays the content of the heap vector over 2 lines. first line is the
	 * index of the parent of each element. Second line are the elements themselves
	 * ie. -1 0 0 1 1 2 2 15 10 14 7 5 12 1
	 */
	public void print() {
		for (int i = 0; i < this.elements.size(); i++) {
			System.out.print(this.elements.get(i) + " ");
		}
		System.out.println();
	}

	// MaxH Testing:

	public static void main(String[] args) {
		// Testing the no-argument constructor
		MaxH heap1 = new MaxH();
		heap1.insert(5);
		heap1.insert(10);
		heap1.insert(3);
		heap1.insert(8);
		heap1.insert(1);
		heap1.print(); // expected output: 10 8 3 5 1

		// Testing the constructor with maximum size
		MaxH heap2 = new MaxH(5);
		heap2.insert(6);
		heap2.insert(2);
		heap2.insert(9);
		heap2.insert(4);
		heap2.insert(7);
		heap2.print(); // expected output: 9 7 6 4 2

		// Testing the constructor with vector of elements
		Vector<Integer> elements = new Vector<Integer>();
		elements.add(8);
		elements.add(2);
		elements.add(6);
		elements.add(5);
		elements.add(1);
		MaxH heap3 = new MaxH(elements);
		heap3.print(); // expected output: 8 5 6 2 1

		// Testing delete method
		heap1.delete(5);
		heap1.print(); // expected output: 10 8 3 1

		// Testing sort method
		heap3.sort();
		heap3.print(); // expected output: 8 6 5 2 1
	}
}