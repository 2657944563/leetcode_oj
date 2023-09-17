/*
下一个更大元素 I
496
2023-09-17 15:27:48
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l = -1, m = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    m = 1;
                }
                if (nums2[j] > nums1[i] && m == 1) {
                    l = nums2[j];
                    break;
                }
            }
            nums1[i] = l;
            l = -1;
            m = 0;
        }
        return nums1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
