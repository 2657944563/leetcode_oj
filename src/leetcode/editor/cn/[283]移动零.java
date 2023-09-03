/*
移动零
283
2023-09-03 19:52:51
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                result[i++] = num;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            nums[j] = result[j];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
