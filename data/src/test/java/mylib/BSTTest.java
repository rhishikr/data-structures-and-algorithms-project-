package mylib;
import mylib.datastructures.trees.BST;
import mylib.datastructures.nodes.TNode;
//import org.junit.jupiter.api.*;

public class BSTTest {

    public static void main(String[] args) {
        // create a BST
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
    }
}


