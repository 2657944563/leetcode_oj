/*
二叉树的所有路径
257
2023-09-12 10:54:45
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dfs(root, new ArrayList<>(), ret);
        return ret;
    }

    private void dfs(TreeNode root, List<String> nodes, List<String> ret) {
        nodes.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            ret.add(String.join("->", nodes));
        }
        if (root.left != null) {
            dfs(root.left, nodes, ret);
        }
        if (root.right != null) {
            dfs(root.right, nodes, ret);
        }
        nodes.remove(nodes.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
