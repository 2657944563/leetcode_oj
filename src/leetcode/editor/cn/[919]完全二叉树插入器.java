/*
完全二叉树插入器
919
2022-07-25 22:00:20
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

class CBTInserter {
    LinkedList<TreeNode> queue = new LinkedList<>();
    TreeNode root;

    public CBTInserter(TreeNode root) {
        LinkedList<TreeNode> tempList = new LinkedList<>();
        tempList.add(root);
        while (!tempList.isEmpty()) {
            TreeNode poll = tempList.peek();
            if (poll.left != null) {
                tempList.add(poll.left);
            }
            if (poll.right != null) {
                tempList.add(poll.right);
                tempList.poll();
            }
            if (poll.left == null || poll.right == null) {
                // 转换
                queue.addAll(tempList);
                break;
            }
        }
        this.root = root;
    }

    public int insert(int val) {
        TreeNode t = queue.peek();
        if (t.left == null) {
            t.left = new TreeNode(val);
            queue.add(t.left);
        } else if (t.right == null) {
            t.right = new TreeNode(val);
            queue.add(t.right);
            queue.poll();
        }
        return t.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)
