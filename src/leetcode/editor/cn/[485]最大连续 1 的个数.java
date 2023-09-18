/*
最大连续 1 的个数
485
2023-09-18 17:03:51
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, temp = 0;

        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        max = Math.max(max, temp);
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
