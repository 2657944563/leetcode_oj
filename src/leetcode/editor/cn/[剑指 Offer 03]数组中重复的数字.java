import java.util.HashSet;

/*
数组中重复的数字
剑指 Offer 03
2022-07-31 11:08:05
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) {
                return nums[i];
            } else {
                hash.add(nums[i]);
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
