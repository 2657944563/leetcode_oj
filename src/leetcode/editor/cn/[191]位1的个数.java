/*
位1的个数
191
2023-09-01 17:36:21
*/
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
