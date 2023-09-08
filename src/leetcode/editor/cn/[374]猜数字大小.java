/*
猜数字大小
374
2023-09-08 23:26:21
*/
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, mid;
        while (l < n) {
            mid = l + (n - l) / 2;
            if (guess(mid) > 0) {
                l = mid + 1;
            } else {
                n = mid;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
