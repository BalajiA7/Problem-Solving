package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

import common.Node;

/**
 * MorrisTraversal
 */
public class MorrisTraversal {

    public static List<Integer> morrisTraversalInOrder(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null)
            return inOrder;
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node rightMost = rightMost(curr.left, curr);
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    rightMost.right = null;
                    inOrder.add(curr.value);
                    curr = curr.right;
                }
            } else {
                inOrder.add(curr.value);
                curr = curr.right;
            }

        }
        return inOrder;
    }

    public static Node rightMost(Node root, Node curr) {
        while (root.right != null && root.right != curr) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        // Left Node
        Node lNode = new Node(2);
        lNode.left = new Node(4);
        lNode.right = new Node(5);
        // Right Node
        Node rNode = new Node(3);
        rNode.right = new Node(7);

        root.left = lNode;
        root.right = rNode;

        System.out.println(morrisTraversalInOrder(root));
    }
}