/*
2 的幂
231
2023-09-03 19:31:32
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
