package BinaryTrees;

import common.Node;

public class BalancedBinaryTree {
    public static boolean balancedTreeBruteForce(Node head) {
        if (head == null)
            return true;
        int lHeight = height(head.left);
        int rHeight = height(head.right);
        if (Math.abs(lHeight - rHeight) > 1) {
            return false;
        }
        if (balancedTreeBruteForce(head.left) == false)
            return false;
        if (balancedTreeBruteForce(head.right) == false)
            return false;
        return true;
    }

    public static int height(Node head) {
        if (head == null)
            return 0;
        return 1 + Math.max(height(head.left), height(head.right));
    }
}
