package mylib.datastructures.heap;

import java.util.Vector;

public abstract class Heap {
	protected Vector<Integer> elements;
	protected Integer size;
	protected Integer maxSize;

	// member functions

	// constructors
	public Heap() {
		this.maxSize = 1;
		this.size = 0;
		this.elements = new Vector<Integer>();
	}

	public Heap(Integer maxSize) {
		this.maxSize = maxSize;
		this.size = 0;

		this.elements = new Vector<Integer>(maxSize + 1);
		this.elements.add(Integer.MIN_VALUE);
	}

	public Heap(Vector<Integer> elements) {
		this.elements = elements;
	}

	// 1: returns the size of the vector containing elements
	public Integer getSize() {
		return this.elements.size();
	}

	// 2: returns a Boolean True if the vector is empty, False otherwise
	public boolean isEmpty() {
		return this.elements.size() == 0;
	}

	// 3: clears the elements of the vector
	public void clear() {
		this.elements.clear();
	}

	// 4: searches for the value “ i ” in the heap
	public boolean contains(Integer i) {
		return this.elements.contains(i);
	}

	// 5: inserts the value key to the vector and maintains heap properties
	public abstract void insert(Integer key);

	// 6: removes the value key from the vector and maintains heap properties
	public abstract void delete(Integer key);

	// 7: applies heapsort to the vector content
	public abstract void sort();

	/*
	 * 8: displays the content of the heap vector over 2 lines. first line is the
	 * index of the
	 * parent of each element. Second line are the elements themselves
	 * ie.
	 * -1 0 0 1 1 2 2
	 * 15 10 14 7 5 12 1
	 */
	public abstract void print();

	// 8: swaps contents of indeces x and y
	protected void swap(int x, int y) {

		int tmp;
		tmp = elements.get(x);

		elements.add(x, elements.get(y));
		elements.add(y, tmp);
	}
}
