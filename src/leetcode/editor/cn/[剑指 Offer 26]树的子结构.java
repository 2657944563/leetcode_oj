/*
树的子结构
剑指 Offer 26
2022-08-02 09:18:22
*/
//leetcode submit region begin(Prohibit modification and deletion)

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null && A == B) {
            return true;
        }
        if (B == null || A == null) {
            return false;
        }
        return cz(A, B);

    }

    boolean cz(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (A != null && B != null && A.val == B.val) {
            if (bl(A, B)) {
                return true;
            }
        }
        return cz(A.left, B) || cz(A.right, B);
    }

    boolean bl(TreeNode A, TreeNode B) {
        if (B != null) {
            if (A == null || B.val != A.val) {
                return false;
            }
            return bl(A.left, B.left) && bl(A.right, B.right);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
