/*
装满石头的背包的最大数量
2279
2023-09-16 10:39:26
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, res = 0;
        for (int i = 0; i < n; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        for (int i = 0; i < n; i++) {
            additionalRocks -= capacity[i];
            if (additionalRocks < 0) break;
            res++;
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
