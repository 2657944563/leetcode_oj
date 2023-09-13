/*
可获得的最大点数
1423
2023-09-13 17:10:17
*/
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length, len = n - k;
        int sum = 0, cur = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        for (int i = 0; i < len; i++) cur += nums[i];
        int min = cur;
        for (int i = len; i < n; i++) {
            cur = cur + nums[i] - nums[i - len];
            min = Math.min(min, cur);
        }
        return sum - min;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
