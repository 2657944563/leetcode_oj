/*
打家劫舍 III
337
2023-09-16 15:00:32
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
    HashMap<TreeNode, Integer> hashMap = new HashMap();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer integer = hashMap.get(root);
        if (integer != null) {
            return integer;
        }

        int val = root.val;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {

            val += rob(root.right.left) + rob(root.right.right);
        }
        int max = Math.max(val, rob(root.left) + rob(root.right));
        hashMap.put(root, max);
        return max;
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
