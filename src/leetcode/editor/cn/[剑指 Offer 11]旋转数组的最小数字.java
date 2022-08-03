/*
旋转数组的最小数字
剑指 Offer 11
2022-07-31 19:20:47
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
