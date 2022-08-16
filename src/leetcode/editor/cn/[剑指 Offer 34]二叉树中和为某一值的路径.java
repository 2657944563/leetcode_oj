/*
二叉树中和为某一值的路径
剑指 Offer 34
2022-08-03 22:41:24
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
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
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dg(root, target, new LinkedList<>());
        return res;
    }

    void dg(TreeNode root, int target, LinkedList<Integer> integers) {
        if (root == null) {
            return;
        }
        if (target - root.val == 0 && root.left == null && root.right == null) {
            integers.add(root.val);
            res.add(integers);
            return;
        }
        integers.add(root.val);
        dg(root.left, target - root.val, (LinkedList<Integer>) integers.clone());
        dg(root.right, target - root.val, (LinkedList<Integer>) integers.clone());

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
