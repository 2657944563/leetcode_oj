/*
颠倒二进制位
190
2023-09-01 17:12:57
*/
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result += 1;
            }
            n >>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
