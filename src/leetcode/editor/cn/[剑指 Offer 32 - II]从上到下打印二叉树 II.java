/*
从上到下打印二叉树 II
剑指 Offer 32 - II
2022-08-02 12:50:00
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
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (linkedList != null && !linkedList.isEmpty()) {
            LinkedList<TreeNode> linkedList1 = new LinkedList<>();
            LinkedList<Integer> integers = new LinkedList<>();
            while (linkedList != null && !linkedList.isEmpty()) {
                TreeNode pop = linkedList.pop();
                integers.add(pop.val);
                if (pop.left != null) {
                    linkedList1.add(pop.left);
                }
                if (pop.right != null) {
                    linkedList1.add(pop.right);
                }
            }
            linkedList = linkedList1;
            res.add(integers);
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
