/*
可获得的最大点数
1423
2023-09-13 17:10:17
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == 1) {
            return cardPoints[0];
        }
        return Math.max(rac(cardPoints, 1, cardPoints.length - 1, k - 1, cardPoints[0]),
                rac(cardPoints, 0, cardPoints.length - 2, k - 1, cardPoints[cardPoints.length - 1]));
    }

    int rac(int[] cardPoints, int l, int r, int n, int sum) {
        if (l > r || r < 0 || n == 0) {
            return sum;
        }
        return Math.max(rac(cardPoints, l + 1, r, n - 1, sum + cardPoints[l]),
                rac(cardPoints, l, r - 1, n - 1, sum + cardPoints[r]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
