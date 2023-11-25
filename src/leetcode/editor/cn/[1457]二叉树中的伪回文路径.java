// 开始时间：2023-11-25 13:44:28
// 题目标题：二叉树中的伪回文路径
// 题目标记：pseudo-palindromic-paths-in-a-binary-tree
// 题目编号：1457
// 题目描述：
/**
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 * 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列
 * [1,2,1] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 * 这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [9]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给定二叉树的节点数目在范围 [1, 10⁵] 内
 * 1 <= Node.val <= 9
 * <p>
 * <p>
 * Related Topics 位运算 树 深度优先搜索 广度优先搜索 二叉树 👍 92 👎 0
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
    public int pseudoPalindromicPaths(TreeNode root) {
        return get(root, 0);
    }

    int get(TreeNode root, int n) {
        n ^= 1 << root.val - 1;
        if (root.left == null && root.right == null) {
            if (sizeN(n) <= 1) {
                return 1;
            } else {
                return 0;
            }
        }
        // System.out.println(root.val + ":" + n);
        if (root.left != null && root.right != null) {
            return get(root.left, n) + get(root.right, n);

        } else if (root.left != null) {

            return get(root.left, n);
        }
        return get(root.right, n);
    }

    int sizeN(int n) {
        int l = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                l++;
            }
            n >>= 1;
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

