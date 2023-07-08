/*
两数之和 II - 输入有序数组
167
2023-07-08 09:59:27
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        // 找到右边界
        for (int i = right; i > 0; i--) {
            if (numbers[i] > target) {
                right = i;
                break;
            }
        }
        for (int i = 0; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                if (i != j
                        && numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[2];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
