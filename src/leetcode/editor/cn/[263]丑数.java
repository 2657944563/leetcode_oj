/*
丑数
263
2023-09-03 21:28:32
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
