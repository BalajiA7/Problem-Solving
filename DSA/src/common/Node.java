package common;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(Node root) {
        this.value = root.value;
        this.left = root.left;
        this.right = root.right;
    }

    public Node(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.value + "";
    }
}
