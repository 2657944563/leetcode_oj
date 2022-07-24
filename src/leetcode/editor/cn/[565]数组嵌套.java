
/*
数组嵌套
565
2022-07-17 00:06:57
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrayNesting(int[] nums) {
        int sums = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i, sum = 0;
            while (true) {
                if (nums[l] == -1) {
                    sums = Math.max(sums, sum);
                    break;
                } else {
                    ++sum;
                    int temp = nums[l];
                    nums[l] = -1;
                    l = temp;
                }
            }
        }
        return sums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
