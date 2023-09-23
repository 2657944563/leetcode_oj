// 开始时间：2023-09-23 18:46:03
// 题目标题：二叉搜索树的最小绝对差
// 题目标记：minimum-absolute-difference-in-bst
// 题目编号：530
// 题目描述：
/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目范围是 [2, 10⁴]
 * 0 <= Node.val <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 相同
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 504 👎 0
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
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode remove = list.remove();
            if (remove.left != null) {
                list.add(remove.left);
            }
            if (remove.right != null) {
                list.add(remove.right);
            }
            min = Math.min(dfs(remove, remove.val), min);
        }
        return min;
    }

    int dfs(TreeNode root, int target) {
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, Math.abs(target - root.left.val));
            min = Math.min(min, dfs(root.left, target));
        }
        if (root.right != null) {
            min = Math.min(min, Math.abs(target - root.right.val));
            min = Math.min(min, dfs(root.right, target));
        }
        return min;
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

