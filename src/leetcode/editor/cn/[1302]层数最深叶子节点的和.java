/*
层数最深叶子节点的和
1302
2022-08-17 08:58:02
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

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
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        int sum = 0;
        list1.add(root);
        while (true) {
            if (list1.isEmpty() && list2.isEmpty()) {
                return sum;
            }
            if (list1.isEmpty()) {
                sum = 0;
                list1.addAll(list2);
                list2.clear();
            }
            while (!list1.isEmpty()) {
                TreeNode t = list1.poll();
                sum += t.val;
                if (t.left != null) {
                    list2.add(t.left);
                }
                if (t.right != null) {
                    list2.add(t.right);
                }
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
