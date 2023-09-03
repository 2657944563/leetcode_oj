/*
平衡二叉树
110
2023-09-03 19:06:02
*/
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    int dfs(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = dfs(head.left);
        int right = dfs(head.right);
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return left == -1 || right == -1 ? -1 : Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
