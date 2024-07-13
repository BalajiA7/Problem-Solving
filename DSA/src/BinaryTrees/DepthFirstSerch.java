package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

import common.Node;
import common.Utils;

public class DepthFirstSerch {
    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void leafNodes(Node root, List<Integer> res) {
        if (root == null)
            return;
        if (Utils.isLeafNode(root)) {
            res.add(root.value);
            return;
        }
        leafNodes(root.left, res);
        leafNodes(root.right, res);
    }

}
