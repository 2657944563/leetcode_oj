import java.util.ArrayList;
import java.util.HashSet;

/*
两个数组的交集
349
2023-09-07 17:53:56
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> n1 = new HashSet();
        for (int i : nums1) {
            n1.add(i);
        }
        for (int i : nums2) {
            if (n1.contains(i)) {
                n1.remove(i);
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
