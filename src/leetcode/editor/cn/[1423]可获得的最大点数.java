import java.util.LinkedList;
import java.util.List;

/*
可获得的最大点数
1423
2023-09-13 17:10:17
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        List<Integer> list = new LinkedList<>();
        int n = cardPoints.length - k, result = 0, min = Integer.MAX_VALUE, tmin = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            result += cardPoints[i];
            tmin = i + n <= cardPoints.length ? 0 : tmin;
            for (int j = i; j < i + n && i + n <= cardPoints.length; j++) {
                tmin += cardPoints[j];
                list.add(cardPoints[j]);
            }
            min = Math.min(min, tmin);
        }
        return result - min;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
