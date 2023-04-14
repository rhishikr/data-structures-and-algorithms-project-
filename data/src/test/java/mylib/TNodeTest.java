package mylib;
import mylib.datastructures.nodes.TNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class TNodeTest {
    @Test
    public void testDataConstructor() {
        TNode node = new TNode(10, 0, null, null, null);
        assertEquals(10, node.getData());
    }

    @Test
    public void testBalanceConstructor() {
        TNode node = new TNode(10, -1, null, null, null);
        assertEquals(-1, node.getBalance());
    }

    @Test
    public void testParentConstructor() {
        TNode parent = new TNode(20, 0, null, null, null);
        TNode node = new TNode(10, 0, parent, null, null);
        assertEquals(parent, node.getParent());
    }

    @Test
    public void testLeftConstructor() {
        TNode left = new TNode(5, 0, null, null, null);
        TNode node = new TNode(10, 0, null, left, null);
        assertEquals(left, node.getLeft());
    }

    @Test
    public void testRightConstructor() {
        TNode right = new TNode(15, 0, null, null, null);
        TNode node = new TNode(10, 0, null, null, right);
        assertEquals(right, node.getRight());
    }

    @Test
    public void testGetData() {
        TNode node = new TNode(10, 0, null, null, null);
        assertEquals(10, node.getData());
    }

    @Test
    public void testSetData() {
        TNode node = new TNode(10, 0, null, null, null);
        node.setData(20);
        assertEquals(20, node.getData());
    }

    @Test
    public void testGetLeft() {
        TNode left = new TNode(5, 0, null, null, null);
        TNode node = new TNode(10, 0, null, left, null);
        assertEquals(left, node.getLeft());
    }

    @Test
    public void testSetLeft() {
        TNode node = new TNode(10, 0, null, null, null);
        TNode left = new TNode(5, 0, null, null, null);
        node.setLeft(left);
        assertEquals(left, node.getLeft());
    }

    @Test
    public void testGetRight() {
        TNode right = new TNode(15, 0, null, null, null);
        TNode node = new TNode(10, 0, null, null, right);
        assertEquals(right, node.getRight());
    }

    @Test
    public void testSetRight() {
        TNode node = new TNode(10, 0, null, null, null);
        TNode right = new TNode(15, 0, null, null, null);
        node.setRight(right);
        assertEquals(right, node.getRight());
    }

    @Test
    public void testGetParent() {
        TNode parent = new TNode(20, 0, null, null, null);
        TNode node = new TNode(10, 0, parent, null, null);
        assertEquals(parent, node.getParent());
    }

    @Test
    public void testSetParent() {
        TNode node = new TNode(10, 0, null, null, null);
        TNode parent = new TNode(20, 0, null, null, null);
        node.setParent(parent);
        assertEquals(parent, node.getParent());
    }

    @Test
    public void testGetBalance() {
        TNode node = new TNode();
        node.setBalance(2);
        assertEquals(2, node.getBalance());
    }

    @Test
    public void testSetBalance() {
        TNode node = new TNode();
        node.setBalance(2);
        assertEquals(2, node.getBalance());
    }

    @Test
    public void testPrint() {
        TNode node = new TNode(5, 0, null, null, null);
        node.print();
    }

    @Test
    public void testToString() {
        TNode node = new TNode(5, 0, null, null, null);
        assertEquals("5", node.toString());
    }
}
