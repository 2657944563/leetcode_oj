// 开始时间：2023-09-20 10:52:58
// 题目标题：两数之和 IV - 输入二叉搜索树
// 题目标记：two-sum-iv-input-is-a-bst
// 题目编号：653
// 题目描述：
/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 二叉树的节点个数的范围是 [1, 10⁴].
 * -10⁴ <= Node.val <= 10⁴
 * 题目数据保证，输入的 root 是一棵 有效 的二叉搜索树
 * -10⁵ <= k <= 10⁵
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 484 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashDfs(hashMap, root);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer i = hashMap.get(k - entry.getKey());
            if (i != null) {
                if (entry.getKey() + entry.getKey() == k && i == 2) {
                    return true;
                } else if (entry.getKey() != k - entry.getKey()) {
                    return true;
                }
            }
        }
        return false;

    }

    void hashDfs(HashMap<Integer, Integer> hashMap, TreeNode root) {
        if (root == null) {
            return;
        }
        hashMap.merge(root.val, 1, Integer::sum);
        hashDfs(hashMap, root.left);
        hashDfs(hashMap, root.right);
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

