/*
调整数组顺序使奇数位于偶数前面
剑指 Offer 21
2022-08-01 11:00:33
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right && left < nums.length && right >= 0) {
            while ((left < right && (nums[left] & 1) == 1)) {
                left++;
            }
            while ((left < right && (nums[right] & 1) == 0)) {
                right--;
            }
            if (left < right) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
