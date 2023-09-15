/*
宝石补给
LCP 50
2023-09-15 09:12:55
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int[] operation : operations) {
            gem[operation[1]] += gem[operation[0]] / 2;
            gem[operation[0]] = gem[operation[0]] - gem[operation[0]] / 2;
        }
        for (int i : gem) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
