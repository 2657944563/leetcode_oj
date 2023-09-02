/*
最多可以摧毁的敌人城堡数目
2511
2023-09-02 11:11:31
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int captureForts(int[] forts) {
        int n = 0, result = 0;

        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                n = i;
                break;
            }
        }
        for (int i = n; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (forts[i] != forts[n]) {
                    result = Math.max(result, i - n - 1);
                }
                n = i;
            }
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
