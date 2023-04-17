package mylib.datastructures.nodes;

public class DNode {
    public Integer value;
    public DNode next;
    private DNode prev;

    public DNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    public String toString() {
        return value.toString();
    }

}
