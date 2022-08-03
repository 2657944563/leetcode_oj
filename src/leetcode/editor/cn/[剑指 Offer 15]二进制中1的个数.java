/*
二进制中1的个数
剑指 Offer 15
2022-07-31 20:57:23
*/
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int m = 0;
        while (n >>> 1 != 0) {
            if ((n & 1) == 1) {
                m++;
            }
            n = n >>> 1;
        }
        return m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
