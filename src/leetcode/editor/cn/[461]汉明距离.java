/*
汉明距离
461
2023-09-04 20:54:25
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        y = 0;
        while (x > 0) {
            if ((x & 1) == 1) y++;
            x >>= 1;
        }
        return y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
