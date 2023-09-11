/*
统计对称整数的数目
2843
2023-09-11 16:38:33
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        // 暴力法：枚举可能出现的数字
        int[] possibleNum = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        for (int n : possibleNum) {
            if (n >= low && n <= high) {
                cnt++;
            }
        }

        if (high < 1000) {
            return cnt;
        }
        if (low < 1000) {
            low = 1000;
        }

        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            if (s.charAt(0) + s.charAt(1) == s.charAt(2) + s.charAt(3)) {
                cnt++;
            }
        }
        return cnt;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
