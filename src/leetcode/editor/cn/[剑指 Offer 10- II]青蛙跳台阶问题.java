/*
青蛙跳台阶问题
剑指 Offer 10- II
2022-07-31 19:16:04
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        int a = 1, b = 2, t = 0;
        if (n == 0 || n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        while (--n > 1) {
            t = a;
            a = b;
            b = (a + t) % 1000000007;
        }
        return b;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
