/*
两数相除
29
2023-07-08 10:35:10
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        long res = (long) dividend / (long) divisor;
        return Math.toIntExact(res > Integer.MAX_VALUE ? Integer.MAX_VALUE :
                res < Integer.MIN_VALUE ? Integer.MIN_VALUE : res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
