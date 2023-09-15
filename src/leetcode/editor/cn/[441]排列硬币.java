/*
排列硬币
441
2023-09-15 10:53:05
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        int i = 0;
        for (int j = 1; n / j > 0; j++) {
            i++;
            n -= j;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
