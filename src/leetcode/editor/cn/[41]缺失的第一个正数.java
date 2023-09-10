import java.util.HashSet;

/*
缺失的第一个正数
41
2023-09-10 16:57:48
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int t = 1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            t = Math.min(t, num < 0 ? t : num);
            hashSet.add(num);
        }
        while (!hashSet.isEmpty()) {
            if (!hashSet.remove(t) && t > 0) {
                return t;
            }
            t++;
        }
        return t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
