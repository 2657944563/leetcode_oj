/*
斐波那契数列
剑指 Offer 10- I
2022-07-31 19:03:47
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        int a = 1, b = 1, t = 0;
        if (n == 1 || n == 2) {
            return a;
        }
        if (n == 0) {
            return 0;
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
