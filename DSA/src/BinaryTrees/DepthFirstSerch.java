package BinaryTrees;

import common.Node;

public class DepthFirstSerch {
    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

}
