// 开始时间：2023-09-24 09:25:11
// 题目标题：根据二叉树创建字符串
// 题目标记：construct-string-from-binary-tree
// 题目编号：606
// 题目描述：
/**
 * 给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
 * <p>
 * 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4]
 * 输出："1(2(4))(3)"
 * 解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出："1(2()(4))(3)"
 * 解释：和第一个示例类似，但是无法省略第一个空括号对，否则会破坏输入与输出一一映射的关系。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目范围是 [1, 10⁴]
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 字符串 二叉树 👍 385 👎 0
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
    StringBuilder result = new StringBuilder();

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        result.append("(");
        result.append(root.val);
        tree2str(root.left);
        if (root.left == null && root.right != null) {
            result.append("()");
        }
        tree2str(root.right);
        result.append(")");
        return result.substring(1, result.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

