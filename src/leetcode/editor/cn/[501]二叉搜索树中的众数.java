// 开始时间：2023-09-19 18:53:51
// 题目标题：二叉搜索树中的众数
// 题目标记：find-mode-in-binary-search-tree
// 题目编号：501
// 题目描述：
/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目在范围 [1, 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 690 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)

//import cn.collection.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        dfs(root, hashMap);
        Integer value = hashMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        int[] ints = hashMap.entrySet().stream().filter(o -> o.getValue().equals(value)).map(Map.Entry::getKey).mapToInt(Integer::valueOf).toArray();
        return ints;
    }

    void dfs(TreeNode rootNode, HashMap<Integer, Integer> hashMap) {
        if (rootNode == null) {
            return;
        }
        hashMap.merge(rootNode.val, 1, Integer::sum);
        dfs(rootNode.left, hashMap);
        dfs(rootNode.right, hashMap);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

