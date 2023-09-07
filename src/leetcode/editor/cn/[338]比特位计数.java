/*
比特位计数
338
2023-09-07 17:48:46
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int m, s;
        for (int i = 0; i <= n; i++) {
            s = i;
            m = 0;
            while (s > 0) {
                s &= s - 1;
                m++;
            }
            result[i] = m;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
