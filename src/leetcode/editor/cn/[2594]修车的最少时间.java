/*
修车的最少时间
2594
2023-09-07 16:30:15
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long repairCars(int[] ranks, int cars) {
        return rac(ranks, 1, (long) cars * cars * ranks[0], cars);
    }

    long rac(int[] ranks, long minMinute, long maxMinute, int cars) {
        long n, mid;
        while (maxMinute > minMinute) {
            n = 0;
            mid = minMinute + (maxMinute - minMinute) / 2;
            for (int rank : ranks) {
                n += Math.sqrt(mid / rank);
            }
            if (n < cars) {
                minMinute = mid + 1;
            } else {
                maxMinute = mid;
            }
        }
        return minMinute;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
