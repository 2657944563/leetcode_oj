/*
将有序数组转换为二叉搜索树
108
2023-09-01 17:19:01
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode treeNode = new TreeNode(nums[(l + r) / 2]);
        treeNode.left = dfs(nums, l, (l + r) / 2 - 1);
        treeNode.right = dfs(nums, (l + r) / 2 + 1, r);
        return treeNode;

    }
}
//
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
