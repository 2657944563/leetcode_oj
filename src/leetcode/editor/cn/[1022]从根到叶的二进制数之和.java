// 开始时间：2023-10-17 23:03:13
// 题目标题：从根到叶的二进制数之和
// 题目标记：sum-of-root-to-leaf-binary-numbers
// 题目编号：1022
// 题目描述：
/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [0]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中的节点数在 [1, 1000] 范围内
 * Node.val 仅为 0 或 1
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 二叉树 👍 241 👎 0
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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return (sum << 1) + root.val;
        }
        return dfs(root.right, (sum << 1) + root.val) + dfs(root.left, (sum << 1) + root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

