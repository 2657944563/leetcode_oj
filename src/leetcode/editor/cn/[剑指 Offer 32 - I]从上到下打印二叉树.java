/*
从上到下打印二叉树
剑指 Offer 32 - I
2022-08-02 12:29:49
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    LinkedList<Integer> link = new LinkedList<>();
    LinkedList<TreeNode> link1 = new LinkedList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        link1.add(root);
        while (!link1.isEmpty()) {
            root = link1.pop();
            link.addLast(root.val);
            if (root.left != null) link1.add(root.left);
            if (root.right != null) link1.add(root.right);

        }
        int[] res = new int[link.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = link.pop();
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
