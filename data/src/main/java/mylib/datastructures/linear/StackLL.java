package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

class StackLL extends SLL {
	DNode top;

	public StackLL() {
		this.top = null;
	}

	// Push an element onto the stack
	public void push(int data) {
		DNode newNode = new DNode(data);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	// Pop an element from the stack
	public int pop() {
		if (top == null) {
			System.out.println("Stack is empty");
			return -1; // return a default value to indicate empty stack
		} else {
			int data = top.getValue();
			top = top.getNext();
			return data;
		}
	}

	// Peek the top element of the stack
	public int peek() {
		if (top == null) {
			System.out.println("Stack is empty");
			return -1; // return a default value to indicate empty stack
		} else {
			return top.getValue();
		}
	}

	// Check if the stack is empty
	public boolean isEmpty() {
		return top == null;
	}

	// Display the stack
	public void display() {
		if (top == null) {
			System.out.println("Stack is empty");
			return;
		}
		DNode current = top;
		System.out.print("Stack: ");
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.getNext();
		}
		System.out.println();
	}

	// Override insert methods to prevent their use in a stack
	@Override
	public void insert(DNode node, Integer position) {
	}

	@Override
	public void sortedInsert(DNode node) {
	}

	@Override
	public void insertTail(DNode node) {
	}

	// Override delete methods to prevent their use in a stack
	@Override
	public void delete(DNode node) {
	}

	@Override
	public void deleteTail() {
	}

	// StackLL test
	public static void main(String[] args) {
		StackLL stack = new StackLL();

		// Test push method
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.display(); // Output: Stack: 40 30 20 10

		// Test pop method
		int data = stack.pop();
		System.out.println("Popped element: " + data); // Output: Popped element: 40
		stack.display(); // Output: Stack: 30 20 10

		// Test peek method
		data = stack.peek();
		System.out.println("Top element: " + data); // Output: Top element: 30

		// Test isEmpty method
		System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? false

		// Test inserting methods (should not work in a stack)
		stack.insert(new DNode(50), 2); // Should print "Cannot insert in a stack"
		stack.sortedInsert(new DNode(60)); // Should print "Cannot insert in a stack"
		stack.insertTail(new DNode(70)); // Should print "Cannot insert in a stack"

		// Test deleting methods (should not work in a stack)
		stack.delete(new DNode(20)); // Should print "Cannot delete from a stack"
		stack.deleteTail(); // Should print "Cannot delete from a stack"
	}
}
