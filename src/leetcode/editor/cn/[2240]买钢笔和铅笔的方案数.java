/*
买钢笔和铅笔的方案数
2240
2023-09-01 16:35:21
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long sum = 0L;
        for (int i = 0; i <= total / cost1; i++) {
            sum += (total - i * cost1) / cost2 + 1;
        }
        return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
