/*
3 的幂
326
2023-09-03 19:35:14
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1 || n == 3) {
            return true;
        }
        if (n < 0 || (n & 1) != 1) {
            return false;
        }
        return dfs(n);
    }

    boolean dfs(int n) {
        if (n == 1) {
            return true;
        } else if (n % 3 != 0) {
            return false;
        }
        return dfs(n / 3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
