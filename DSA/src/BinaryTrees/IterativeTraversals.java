package BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import common.Node;

public class IterativeTraversals {
    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<Node> stk = new Stack<>();
        stk.add(root);

        while (!stk.isEmpty()) {
            Node top = stk.pop();
            ans.add(top.value);
            if (top.right != null) {
                stk.add(top.right);
            }
            if (top.left != null) {
                stk.add(top.left);
            }
        }

        return ans;
    }

    public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<Node> stk = new Stack<>();
        Node temp = root;

        while (true) {
            if (temp != null) {
                stk.add(temp);
                temp = temp.left;
            } else {
                if (stk.isEmpty())
                    break;

                Node top = stk.pop();
                ans.add(top.value);
                temp = top.right;
            }
        }

        return ans;
    }

    public static List<Integer> postOrderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<Node> stk = new Stack<>();
        stk.add(root);

        while (!stk.isEmpty()) {
            Node top = stk.pop();
            ans.add(top.value);
            if (top.left != null) {
                stk.add(top.left);
            }
            if (top.right != null) {
                stk.add(top.right);
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    public static List<Integer> levelOrderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node top = queue.poll();
            ans.add(top.value);
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }

        return ans;
    }
}
