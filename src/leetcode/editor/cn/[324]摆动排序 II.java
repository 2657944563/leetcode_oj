//import java.util.Arrays;

import java.util.Arrays;

/*
摆动排序 II
324
2022-06-28 17:53:34
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        //首先排序，然后分成两段，依次用两段的最大数填充数组
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int r = nums.length % 2 == 1 ? nums.length / 2 + 1 : nums.length / 2;
        int n = 0;
        for (int i = nums.length - 1, l = r - 1; i >= r && l >= 0; i--, l--) {
            res[n++] = nums[l];
            res[n++] = nums[i];
            if (i == r && l == 1) {
                res[n++] = nums[--l];
            }
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
