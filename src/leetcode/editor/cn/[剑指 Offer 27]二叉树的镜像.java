
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
    TreeNode Temp;

    public TreeNode mirrorTree(TreeNode root) {
        jx(root);
        return root;
    }

    void jx(TreeNode root) {
        if (root != null) {
            Temp = root.left;
            root.left = root.right;
            root.right = Temp;
            jx(root.left);
            jx(root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
