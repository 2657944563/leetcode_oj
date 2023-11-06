// 开始时间：2023-11-03 20:42:07
// 题目标题：找出克隆二叉树中的相同节点
// 题目标记：find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
// 题目编号：1379
// 题目描述：
/**
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 * <p>
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 * <p>
 * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：你 不能 对两棵二叉树，以及 target 节点进行更改。只能 返回对克隆树 cloned 中已有的节点的引用。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: tree = [7,4,3,null,null,6,19], target = 3
 * 输出: 3
 * 解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其
 * 他示例类似）。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: tree = [7], target =  7
 * 输出: 7
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数量范围为
 * [1, 10⁴] 。
 * 同一棵树中，没有值相同的节点。
 * target 节点是树 original 中的一个节点，并且不会是 null 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：如果树中允许出现值相同的节点，将如何解答？
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 66 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)

//import cn.collection.TreeNode;

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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode targetCopy = getTargetCopy(original.right, cloned.right, target);
        if (targetCopy != null) {
            return targetCopy;
        }
        targetCopy = getTargetCopy(original.left, cloned.left, target);
        if (targetCopy != null) {
            return targetCopy;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

