/*
对称的二叉树
剑指 Offer 28
2022-08-02 10:10:25
*/
//leetcode submit region begin(Prohibit modification and deletion)

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dc(root.left, root.right);

    }

    boolean dc(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return dc(left.left, right.right) && dc(left.right, right.left);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
