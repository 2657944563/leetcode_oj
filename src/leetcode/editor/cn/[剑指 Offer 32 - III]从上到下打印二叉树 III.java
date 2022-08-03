/*
从上到下打印二叉树 III
剑指 Offer 32 - III
2022-08-03 21:41:18
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
        boolean flag = true; // 正序
        while (linkedList != null && !linkedList.isEmpty()) {
            LinkedList<TreeNode> linkedList1 = new LinkedList<>();
            LinkedList<Integer> integers = new LinkedList<>();
            while (linkedList != null && !linkedList.isEmpty()) {
                TreeNode pop = linkedList.pop();
                if (flag) {
                    integers.add(pop.val);
                    if (pop.left != null) {
                        linkedList1.addFirst(pop.left);
                    }
                    if (pop.right != null) {
                        linkedList1.addFirst(pop.right);
                    }
                } else {
                    integers.add(pop.val);
                    if (pop.right != null) {
                        linkedList1.addFirst(pop.right);
                    }
                    if (pop.left != null) {
                        linkedList1.addFirst(pop.left);
                    }
                }
            }
            linkedList = linkedList1;
            res.add(integers);
            flag = !flag;
            System.out.println(flag);
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
