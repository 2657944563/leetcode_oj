import java.util.Arrays;
import java.util.HashSet;

/*
从两个数字数组里生成最小数字
2605
2023-09-05 00:32:47
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet h = new HashSet(16);
        for (int i : nums1) {
            h.add(i);
        }
        for (int i : nums2) {
            if (h.contains(i)) {
                return i;
            }
        }
        return nums1[0] > nums2[0] ? nums2[0] * 10 + nums1[0] : nums1[0] * 10 + nums2[0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
