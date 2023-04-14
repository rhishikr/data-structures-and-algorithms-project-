package mylib;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;
import mylib.datastructures.trees.BST;
import mylib.graphalgo.Graph;

public class App {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Testing BST:");
        System.out.println();
        BST bst = new BST();

        // insert nodes
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(10);
        bst.insert(25);
        bst.insert(35);
        bst.insert(45);
        bst.insert(55);
        bst.insert(65);
        bst.insert(75);
        bst.insert(85);

        // print in-order traversal
        System.out.println("In-order traversal:");
        bst.printInOrder();

        // print BFS
        System.out.println("\nBFS:");
        bst.printBF();

        // search node
        int val = 40;
        TNode node = bst.search(val);
        System.out.println("\nSearch for value " + val + ":");
        if (node != null) {
            System.out.println("Node found: " + node.getData());
        } else {
            System.out.println("Node not found.");
        }

        // delete node
        val = 60;
        System.out.println("\nDelete node with value " + val + ":");
        bst.delete(val);

        // print in-order traversal after deletion
        System.out.println("\nIn-order traversal after deletion:");
        bst.printInOrder();

        // print BFS after deletion
        System.out.println("\nBFS after deletion:");
        bst.printBF();


        System.out.println();
        System.out.println("Testing AVL:");
        System.out.println();

        AVL avl = new AVL();
        System.out.println("Inserting values...");
        avl.insert(5);

        avl.insert(3);
        avl.insert(2);
        avl.insert(4);
        avl.insert(7);
        avl.insert(6);
        avl.insert(8);

        System.out.println("\nPrinting tree in order...");
        avl.printInOrder();

        System.out.println("\nPrinting balance factors...");
        avl.printBF();

        System.out.println("\nDeleting node with value 4...");
        avl.delete(4);

        System.out.println("\nPrinting tree in order after deletion...");
        avl.printInOrder();

        System.out.println("\nPrinting balance factors after deletion...");
        avl.printBF();
        System.out.println();
        System.out.println();
        System.out.println("Testing GraphAlgorithm:");
        System.out.println();

        Graph graph = new Graph(0);

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 4, 5);
        graph.addEdge(4, 5, 6);

        boolean[] visited = new boolean[graph.order];
        System.out.println("DFS:");
        graph.dfs(1, visited);
        System.out.println();

        System.out.println("BFS:");
        graph.bfs(1);
        System.out.println();

        System.out.println("Dijkstra's:");
        graph.dijkstra(1);

    }
    }

