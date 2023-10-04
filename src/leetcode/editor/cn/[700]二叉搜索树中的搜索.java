// 开始时间：2023-10-03 15:08:43
// 题目标题：二叉搜索树中的搜索
// 题目标记：search-in-a-binary-search-tree
// 题目编号：700
// 题目描述：
/**
 * 给定二叉搜索树（BST）的根节点
 * root 和一个整数值
 * val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
 * null 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 数中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 10⁷
 * root 是二叉搜索树
 * 1 <= val <= 10⁷
 * <p>
 * <p>
 * Related Topics 树 二叉搜索树 二叉树 👍 436 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)

//import cn.collection.TreeNode;

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

