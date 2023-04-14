package mylib;
import mylib.datastructures.trees.AVL;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AVLTest {

    @Test
    void testConstructor() {
        AVL tree = new AVL();
        assertNull(tree.getRoot());

        AVL tree2 = new AVL(5);
        assertEquals(5, tree2.getRoot().getData());
    }

    @Test
    void testInsert() {
        AVL tree = new AVL();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);

        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(7, tree.getRoot().getRight().getData());
        assertEquals(1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(9, tree.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testDelete() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);
        tree.insert(17);

        // Test deleting a leaf node
        assertNotNull(tree.search(3));
        tree.delete(3);
        assertNull(tree.search(3));

        // Test deleting a node with one child
        assertNotNull(tree.search(12));
        tree.delete(12);
        assertNull(tree.search(12));

        // Test deleting a node with two children
        assertNotNull(tree.search(10));
        tree.delete(10);
        assertNull(tree.search(10));

        // Test deleting the root node
        assertNotNull(tree.search(15));
        tree.delete(15);
        assertNull(tree.search(15));
    }


    @Test
    void testSearch() {
        AVL tree = new AVL();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);

        assertNotNull(tree.search(5));
        assertNotNull(tree.search(3));
        assertNotNull(tree.search(7));
        assertNotNull(tree.search(1));
        assertNotNull(tree.search(9));
        assertNull(tree.search(2));
    }

    @Test
    void testPrintInOrder() {
        AVL tree = new AVL();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);

        tree.printInOrder();
        // Expected output: 1 3 5 7 9
    }

    @Test
    void testPrintBF() {
        AVL tree = new AVL();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);

        tree.printBF();
        // Expected output: 0 1 0 -1 0
    }
}