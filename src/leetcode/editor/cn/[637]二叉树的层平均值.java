// 开始时间：2023-10-03 15:08:41
// 题目标题：二叉树的层平均值
// 题目标记：average-of-levels-in-binary-tree
// 题目编号：637
// 题目描述：
/**
 * 给定一个非空二叉树的根节点
 * root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 树中节点数量在 [1, 10⁴] 范围内
 * -2³¹ <= Node.val <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 454 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)

//import cn.collection.TreeNode;
//
//import java.util.LinkedList;
//import java.util.List;

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
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Double> result = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            LinkedList<TreeNode> tempList = new LinkedList<>();
            double sum = 0L;
            int count = 0;
            while (!list.isEmpty()) {
                TreeNode treeNode = list.removeFirst();
                sum += treeNode.val;
                count++;
                if (treeNode.left != null) {
                    tempList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempList.add(treeNode.right);
                }
            }
            result.add(sum / count);
            list.clear();
            list.addAll(tempList);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

