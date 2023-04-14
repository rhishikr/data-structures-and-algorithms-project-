package mylib;
import mylib.datastructures.trees.AVL;

public class AVLTest {
    public static void main(String[] args) {
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
    }

}
