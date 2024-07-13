package BinaryTrees;

import java.util.ArrayList;

import common.Node;

public class Treepath {
    public static void rootToPath(Node head, ArrayList<Integer> arr) {
        if (head == null)
            return;
        if (head.left == null && head.right == null) {
            arr.add(head.value);
            System.out.println(arr);
            return;
        }
        arr.add(head.value);
        rootToPath(head.left, arr);
        arr.remove(arr.size() - 1);
        rootToPath(head.right, arr);
    }
}
