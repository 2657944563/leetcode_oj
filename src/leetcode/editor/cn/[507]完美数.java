/*
完美数
507
2023-09-18 18:05:58
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPerfectNumber(int num) {
        int result = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                result += i;
            }
        }
        return result == num;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
