package mylib.datastructures.heap;

import java.util.Vector;

public class MinH extends Heap {

	// constructors
	public MinH() {
		super();
	}

	public MinH(Integer maxSize) {
		super(maxSize);
	}

	public MinH(Vector<Integer> elements) {
		super(elements);
	}

	// 1: return parent of elements[i]
	private int parent(int i) {
		return i / 2;
	}

	// 2: returns left child of elements[i]
	private int left(int i) {
		return (2 * i);
	}

	// 3: returns right child of elements[i]
	private int right(int i) {
		return (2 * i) + 1;
	}

	// heapification process after deletion
	private void heapifyDown(int i) {
		int left = left(i);
		int right = right(i);
		int smallest = i;

		if (left <= size && elements.get(left) < elements.get(smallest)) {
			smallest = left;
		}

		if (right <= size && elements.get(right) < elements.get(smallest)) {
			smallest = right;
		}

		if (smallest != i) {
			swap(i, smallest);
			heapifyDown(smallest);
		}
	}

	// heapification process after insertion
	private void heapifyUp(int i) {
		while (i > 1 && elements.get(parent(i)) > elements.get(i)) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	/*
	 * takes in an array of values and returns a valid heap this can be used by
	 * sort() and the third overload constructor
	 */
	private Vector<Integer> heapify(int[] array) {
		Vector<Integer> elements = new Vector<>();
		for (int i = 0; i < array.length; i++) {
			elements.add(array[i]);
		}
		for (int i = elements.size() / 2 - 1; i >= 0; i--) {
			heapifyDown(i);
		}
		return elements;
	}

	// 5: inserts the value key to the vector and maintains heap properties
	public void insert(Integer key) {
		if (size >= maxSize) {
			return;
		}

		elements.add(key);
		size++;
		heapifyUp(size);
	}

	// 6: removes the value key from the vector and maintains heap properties
	public void delete(Integer key) {
		int index = elements.indexOf(key);

		if (index == -1) {
			return;
		}

		elements.set(index, elements.get(size));
		elements.remove(size);
		size--;
		heapifyDown(index);
	}

	// 7: applies heapsort to the vector content
	public void sort() {
		Vector<Integer> sorted = new Vector<Integer>();
		while (!isEmpty()) {
			sorted.add(elements.get(1));
			elements.set(1, elements.get(size));
			elements.remove(size);
			size--;
			heapifyDown(1);
		}
		elements = sorted;
	}

	/*
	 * 8: displays the content of the heap vector over 2 lines. first line is the
	 * index of the parent of each element. Second line are the elements themselves
	 * ie. -1 0 0 1 1 2 2 15 10 14 7 5 12 1
	 */
	public void print() {
		for (int i = 1; i <= size; i++) {
			System.out.print(parent(i) + " ");
		}
		System.out.println();
		for (int i = 1; i <= size; i++) {
			System.out.print(elements.get(i) + " ");
		}
		System.out.println();
	}

	// minH test
	public static void main(String[] arg) {

		// Display message
		System.out.println("The Min Heap is ");

		// Creating object of class in main() method
		MinH minHeap = new MinH(15);

		// Inserting element to minHeap
		// using insert() method

		// Custom input entries
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);

		// Print all elements of the heap
		minHeap.print();

		// Removing minimum value from above heap and printing it
	}
}