// 开始时间：2023-09-24 08:56:18
// 题目标题：N 叉树的前序遍历
// 题目标记：n-ary-tree-preorder-traversal
// 题目编号：589
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点
 * root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
 * null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 节点总数在范围
 * [0, 10⁴]内
 * 0 <= Node.val <= 10⁴
 * n 叉树的高度小于或等于 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * Related Topics 栈 树 深度优先搜索 👍 378 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root != null) {
            list.add(root);
        }
        int i = list.size();
        while (!list.isEmpty()) {
            System.out.println("size:" + i);
            while (i > 0) {
                i--;
                Node node = list.removeFirst();
                if (i > 0) {
                    list.addAll(0, node.children);
                    i += node.children.size();
                } else {
                    list.addAll(node.children);
                }
                result.add(node.val);
            }
            i = list.size();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

