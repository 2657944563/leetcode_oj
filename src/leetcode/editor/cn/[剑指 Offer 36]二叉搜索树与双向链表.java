import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
二叉搜索树与双向链表
剑指 Offer 36
2022-08-04 10:23:43
*/
//leetcode submit region begin(Prohibit modification and deletion)
/**/
// Definition for a Node.
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val,Node _left,Node _right) {
//        val = _val;
//        left = _left;
//        right = _right;
//    }
//};

class Solution {
    ArrayList<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        prNode(root);
        list.get(0).left = list.get(list.size() - 1);
        list.get(0).right = list.get(0);
        list.get(list.size() - 1).right = list.get(0);
        if (list.size() > 1) {
            list.get(0).right = list.get(1);
            list.get(list.size() - 1).left = list.get(list.size() - 2);
        }
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        return list.get(0);
    }

    void prNode(Node root) {
        if (root == null) {
            return;
        }
        prNode(root.left);
        list.add(root);
        prNode(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
