/*
打印从1到最大的n位数
剑指 Offer 17
2022-07-31 21:24:39
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] printNumbers(int n) {
        int m = 9;
        for (int i = 0; i < n - 1; i++) {
            m = m * 10 + 9;
        }
        int[] res = new int[m];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
