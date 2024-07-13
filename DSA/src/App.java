import java.util.ArrayList;

import javax.swing.plaf.basic.BasicTreeUI.TreePageAction;

import BinaryTrees.BalancedBinaryTree;
import BinaryTrees.IterativeTraversals;
import BinaryTrees.Treepath;
import common.Node;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("This Repository consists of all my Java DSA code!");
        Node root = new Node(1);
        // Left Node
        Node lNode = new Node(2);
        lNode.left = new Node(4);
        lNode.right = new Node(5);
        // Right Node
        Node rNode = new Node(3);
        rNode.left = new Node(-1);
        rNode.right = new Node(7);

        root.left = lNode;
        root.right = rNode;
        // System.out.println(IterativeTraversals.preOrderTraversal(root));
        // System.out.println(IterativeTraversals.inOrderTraversal(root));
        // System.out.println(IterativeTraversals.postOrderTraversal(root));
        // System.out.println(IterativeTraversals.levelOrderTraversal(root));
        // System.out.println(IterativeTraversals.zizZaglevelOrderTraversal(root));
        // System.out.println(IterativeTraversals.boundaryTraversal(root));
        // System.out.println(IterativeTraversals.verticalOrder(root));
        // System.out.println(IterativeTraversals.topView(root));
        // System.out.println(IterativeTraversals.bottomView(root));
        // System.out.println(IterativeTraversals.rightView(root));
        // System.out.println(IterativeTraversals.leftView(root));
        Treepath.rootToPath(root, new ArrayList<>());

        // System.out.println(BalancedBinaryTree.balancedTreeBruteForce(root));
    }
}
