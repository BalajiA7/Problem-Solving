package BinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import common.Node;
import common.Pair;
import common.Pairs;
import common.Utils;

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

    public static List<List<Integer>> zizZaglevelOrderTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> row = new LinkedList<>();
            while (size > 0) {
                Node top = queue.poll();
                if (reverse) {
                    row.addFirst(top.value);
                } else {
                    row.addLast(top.value);
                }
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
                size--;
            }
            res.add(new ArrayList<>(row));
            reverse = !reverse;
        }

        return res;
    }

    public static List<Integer> boundaryTraversal(Node head) {
        ArrayList<Integer> res = new ArrayList<>();
        if (head == null)
            return res;

        if (!Utils.isLeafNode(head)) {
            res.add(head.value);
        }

        // Left boundary
        Node temp = head.left;
        while (temp != null) {
            if (!Utils.isLeafNode(temp)) {
                res.add(temp.value);
            }
            if (temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        // // Leaf nodes
        DepthFirstSerch.leafNodes(head, res);

        // // Right boundary
        temp = head.right;
        Stack<Integer> stk = new Stack<>();
        while (temp != null) {
            if (!Utils.isLeafNode(temp)) {
                stk.add(temp.value);
            }
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        while (!stk.isEmpty()) {
            res.add(stk.pop());
        }

        return res;
    }

    public static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Pairs> queue = new LinkedList<>();
        queue.add(new Pairs(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> hm = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Pairs top = queue.poll();

                int verticalOrder = top.verticalOrder;
                int horizontalOrder = top.horizontalOrder;

                hm.putIfAbsent(verticalOrder, new TreeMap<>());
                hm.get(verticalOrder).putIfAbsent(horizontalOrder, new PriorityQueue<>());
                hm.get(verticalOrder).get(horizontalOrder).add(top.value);

                if (top.left != null) {
                    queue.add(new Pairs(top.left, verticalOrder - 1, horizontalOrder + 1));
                }

                if (top.right != null) {
                    queue.add(new Pairs(top.right, verticalOrder + 1, horizontalOrder + 1));
                }
                size--;
            }
        }

        System.out.println(hm);
        for (TreeMap<Integer, PriorityQueue<Integer>> vertical : hm.values()) {
            List<Integer> verticalOrder = new ArrayList<>();
            for (PriorityQueue<Integer> pQueue : vertical.values()) {
                System.out.println(pQueue);
                while (!pQueue.isEmpty()) {
                    verticalOrder.add(pQueue.poll());
                }
            }
            res.add(verticalOrder);
        }

        return res;

    }

    public static List<Integer> topView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        TreeMap<Integer, Integer> hm = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Pair top = queue.poll();

                int verticalOrder = top.order;

                hm.putIfAbsent(verticalOrder, top.value);

                if (top.left != null) {
                    queue.add(new Pair(top.left, verticalOrder - 1));
                }

                if (top.right != null) {
                    queue.add(new Pair(top.right, verticalOrder + 1));
                }
                size--;
            }
        }

        for (Integer vertical : hm.values()) {
            res.add(vertical);
        }

        return res;
    }

    public static List<Integer> bottomView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        TreeMap<Integer, Integer> hm = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Pair top = queue.poll();

                int verticalOrder = top.order;

                hm.put(verticalOrder, top.value);

                if (top.left != null) {
                    queue.add(new Pair(top.left, verticalOrder - 1));
                }

                if (top.right != null) {
                    queue.add(new Pair(top.right, verticalOrder + 1));
                }
                size--;
            }
        }

        for (Integer vertical : hm.values()) {
            res.add(vertical);
        }

        return res;
    }

    public static List<Integer> rightView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        TreeMap<Integer, Integer> hm = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Pair top = queue.poll();

                int horizontalOrder = top.order;

                hm.put(horizontalOrder, top.value);

                if (top.left != null) {
                    queue.add(new Pair(top.left, horizontalOrder + 1));
                }

                if (top.right != null) {
                    queue.add(new Pair(top.right, horizontalOrder + 1));
                }
                size--;
            }
        }

        for (Integer vertical : hm.values()) {
            res.add(vertical);
        }

        return res;
    }

    public static List<Integer> leftView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        TreeMap<Integer, Integer> hm = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Pair top = queue.poll();

                int horizontalOrder = top.order;

                hm.putIfAbsent(horizontalOrder, top.value);

                if (top.left != null) {
                    queue.add(new Pair(top.left, horizontalOrder + 1));
                }

                if (top.right != null) {
                    queue.add(new Pair(top.right, horizontalOrder + 1));
                }
                size--;
            }
        }

        for (Integer vertical : hm.values()) {
            res.add(vertical);
        }

        return res;
    }

}
