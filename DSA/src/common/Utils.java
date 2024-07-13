package common;

public class Utils {
    public static boolean isLeafNode(Node head) {
        if (head.left == null && head.right == null) {
            return true;
        }
        return false;
    }
}
