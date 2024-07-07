package BinaryTrees;

import common.Node;

public class BinaryTreeToLL {

    public static void convertToLL(Node root) {
        Node head = root;
        while (head != null) {
            if (head.left != null) {
                // Fnd the rightmost element
                Node rightMost = rightMost(head.left);
                // Swap and make left as null
                Node rightTree = head.right;
                Node leftTree = head.left;
                head.right = leftTree;
                head.left = null;
                // Assign right to rightmost element
                rightMost.right = rightTree;
            }
            head = head.right;
        }
    }

    public static Node rightMost(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        // Left Node
        Node lNode = new Node(2);
        lNode.left = new Node(3);
        lNode.right = new Node(4);
        // Right Node
        Node rNode = new Node(5);
        rNode.right = new Node(6);
        rNode.right.left = new Node(7);

        root.left = lNode;
        root.right = rNode;

        convertToLL(root);

        Node head = root;
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.right;
        }

    }
}
