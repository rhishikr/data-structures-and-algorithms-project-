package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class QueueLL extends SLL {
	public QueueLL() {
		super();
	}

	// Overload constructor with a Node object argument to use as head
	public QueueLL(DNode head) {
		super(head);
	}

	// Inserts node object at the tail of the list (same as enqueue in queue)
	public void enqueue(int data) {
		DNode newNode = new DNode(data);
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	// Deletes the head node (same as dequeue in queue)
	public void dequeue() throws Exception {
		super.deleteHead();
	}

	// Returns the head node without deleting it
	public DNode peek() {
		return super.getHead();
	}

	// Override the insertHead method to have empty body as it does not apply to
	// Queue behavior

	public void addFirst(int value) {
		// do nothing
	}

	// Check if the queue is empty
	public boolean isEmpty() {
		return head == null;
	}

	// Display the queue
	public void display() {
		if (head == null) {
			System.out.println("Queue is empty");
			return;
		}

		DNode current = head;
		System.out.print("Queue: ");
		while (current != null) {
			System.out.print(current.getValue() + " ");
			current = current.next;
		}
		System.out.println();
	}

	// QueueLL Test
	public static void main(String[] args) {
		// create an empty queue
		QueueLL queue = new QueueLL();

		// enqueue some elements
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		// display the queue
		queue.display(); // expected output: "Queue: 1 2 3"

		// dequeue an element
		// queue.dequeue();
		queue.display(); // expected output: "Queue: 2 3"

		// peek at the front element
		DNode front = queue.peek();
		System.out.println("Front element: " + front.getValue()); // expected output: "Front element: 2"

		// check if the queue is empty
		System.out.println("Is queue empty? " + queue.isEmpty()); // expected output: "Is queue empty? false"

		// create a new queue with a head node
		DNode head = new DNode(0);
		QueueLL queue2 = new QueueLL(head);

		// enqueue some elements
		queue2.enqueue(4);
		queue2.enqueue(5);

		// display the queue
		queue2.display(); // expected output: "Queue: 0 4 5"
	}
}