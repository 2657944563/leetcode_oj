import java.util.Arrays;

/*
数组中出现次数超过一半的数字
剑指 Offer 39
2022-08-19 15:20:38
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
