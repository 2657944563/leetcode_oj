// 开始时间：2023-10-13 22:55:38
// 题目标题：单值二叉树
// 题目标记：univalued-binary-tree
// 题目编号：965
// 题目描述：
/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 197 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)

//import cn.collection.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val != root.left.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val) {
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

