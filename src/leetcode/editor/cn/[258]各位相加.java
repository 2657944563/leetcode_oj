/*
各位相加
258
2023-09-04 20:59:28
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        return rac(num);
    }

    int rac(int num) {
        if (num < 10) {
            return num;
        }
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return rac(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
