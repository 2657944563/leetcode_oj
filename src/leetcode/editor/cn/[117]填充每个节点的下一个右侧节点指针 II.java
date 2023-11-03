// 开始时间：2023-11-03 10:48:30
// 题目标题：填充每个节点的下一个右侧节点指针 II
// 题目标记：populating-next-right-pointers-in-each-node-ii
// 题目编号：117
// 题目描述：

import java.util.LinkedList;

/**
 * 给定一个二叉树：
 * <p>
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连
 * 接），'#' 表示每层的末尾。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 783 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    LinkedList<Node> list = new LinkedList<>();

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        list.add(root);
        list.add(null);
        while (!list.isEmpty()) {
            Node first = list.pollFirst();
            pu(first, list);
            Node second = list.pollFirst();
            while (second != null) {
                pu(second, list);
                first.next = second;
                first = second;
                second = list.pollFirst();
            }
            if (!list.isEmpty()) {
                list.add(null);
            }
        }
        return root;
    }

    void pu(Node root, LinkedList<Node> list) {
        if (root.left != null) {
            list.add(root.left);
        }
        if (root.right != null) {
            list.add(root.right);
        }
    }

}

//leetcode submit region end(Prohibit modification and deletion)

