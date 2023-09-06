/*
4的幂
342
2023-09-06 23:13:35
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
