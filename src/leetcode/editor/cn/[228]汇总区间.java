import java.util.LinkedList;
import java.util.List;

/*
汇总区间
228
2023-09-09 20:02:24
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        int l = nums[0], r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == r + 1) {
                r++;
            } else {
                if (l == r) {
                    result.add(String.valueOf(l));
                } else {
                    result.add(l + "->" + r);
                }
                l = nums[i];
                r = l;
            }
        }
        if (l == r) {
            result.add(String.valueOf(l));
        } else {
            result.add(l + "->" + r);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
