import java.util.Stack;

/*
栈的压入、弹出序列
剑指 Offer 31
2022-08-02 11:24:26
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] a, int[] b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        int n = 0, m = 0;
        Stack<Integer> stack = new Stack<>();
        while (n < a.length && m < b.length) {
            if (stack.isEmpty()) {
                stack.push(a[n++]);
                continue;
            }
            if (stack.peek() != b[m]) {
                stack.push(a[n++]);
            } else {
                stack.pop();
                m++;
            }
        }
        while (m < b.length) {
            if (stack.pop() != b[m++]) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
