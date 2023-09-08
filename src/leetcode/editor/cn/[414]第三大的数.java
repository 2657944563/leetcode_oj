import java.util.Arrays;

/*
第三大的数
414
2023-09-08 10:11:50
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        nums = Arrays.stream(nums).distinct().toArray();
        return nums.length < 3 ? nums[nums.length - 1] : nums[nums.length - 3];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
