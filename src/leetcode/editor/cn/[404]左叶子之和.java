/*
左叶子之和
404
2023-09-09 20:47:17
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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int n) {
        if (root == null) {
            return n;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                n += root.left.val;
            }
            n = dfs(root.left, n);
        }
        if (root.right == null) {
            return n;
        }
        return dfs(root.right, n);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
