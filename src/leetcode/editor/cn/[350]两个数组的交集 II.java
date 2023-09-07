import java.util.Arrays;
import java.util.LinkedList;

/*
两个数组的交集 II
350
2023-09-07 18:12:08
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        LinkedList<Integer> list = new LinkedList<>();
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                list.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
