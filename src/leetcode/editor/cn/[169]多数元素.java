import java.util.Arrays;

/*
多数元素
169
2023-07-05 18:34:17
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
