/*
最深叶节点的最近公共祖先
1123
2023-09-06 10:11:47
*/
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
    List<TreeNode> list = new LinkedList<>();
    HashMap<Integer, List<TreeNode>> resultMap = new HashMap<>(16);

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        addKanoko(root, 1);
        List<Integer> listTemp = new ArrayList<>(resultMap.keySet());
        listTemp.sort((o1, o2) -> o2 - o1);
        list = resultMap.get(listTemp.get(0));
        list.stream().map(o -> o.val).forEach(System.out::println);
        return checkResult(root);
    }

    TreeNode checkResult(TreeNode root) {
        if (root == null) {
            return null;
        }
        for (TreeNode target : list) {
            boolean check = check(root, target);
            if (!check) {
                return null;
            }
        }
        TreeNode right = checkResult(root.right);
        if (right != null) {
            return right;
        }
        TreeNode left = checkResult(root.left);
        if (left != null) {
            return left;
        }
        return root;
    }


    void addKanoko(TreeNode root, int i) {
        if (root == null) {
        } else if (root.left == null && root.right == null) {
            if (resultMap.containsKey(i)) {
                resultMap.get(i).add(root);
            } else {
                List<TreeNode> listTemp = new LinkedList<>();
                listTemp.add(root);
                resultMap.put(i, listTemp);
            }
        } else {
            addKanoko(root.left, i + 1);
            addKanoko(root.right, i + 1);
        }
    }

    boolean check(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        } else if (root == target) {
            return true;
        }
        return check(root.left, target) || check(root.right, target);
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
