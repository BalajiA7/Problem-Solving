import BinaryTrees.IterativeTraversals;
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
        rNode.right = new Node(7);

        root.left = lNode;
        root.right = rNode;
        System.out.println(IterativeTraversals.preOrderTraversal(root));
        System.out.println(IterativeTraversals.inOrderTraversal(root));
        System.out.println(IterativeTraversals.postOrderTraversal(root));
        System.out.println(IterativeTraversals.levelOrderTraversal(root));
    }
}
