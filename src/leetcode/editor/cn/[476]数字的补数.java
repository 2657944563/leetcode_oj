/*
数字的补数
476
2023-09-17 15:39:19
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findComplement(int num) {
        int i = 0, result = 0;
        while (num > 0) {
            if (num % 2 != 1) {
                result += 1 << i;
            }
            num /= 2;
            i++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
