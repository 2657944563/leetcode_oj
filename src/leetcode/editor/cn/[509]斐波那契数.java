/*
斐波那契数
509
2023-09-15 10:04:13
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dp = new int[31];

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int fib1 = fib(n - 1);
        int fib2 = fib(n - 2);
        dp[n] = fib1 + fib2;
        dp[n - 1] = fib1;
        dp[n - 2] = fib2;
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
