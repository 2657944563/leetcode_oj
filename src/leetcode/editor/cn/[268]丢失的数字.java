/*
丢失的数字
268
2023-09-07 18:00:42
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int[] result = new int[nums.length + 1];
        for (int num : nums) {
            if (num < result.length + 1) {
                result[num] = 1;
            }
        }
        for (int i = 0; i < result.length + 1; i++) {
            if (result[i] != 1) {
                return i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
