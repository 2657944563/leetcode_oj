/*
提莫攻击
495
2023-09-18 17:27:46
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] >= duration) {
                sum += duration;
            } else {
                sum += timeSeries[i] - timeSeries[i - 1];
            }
        }
        return sum + duration;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
