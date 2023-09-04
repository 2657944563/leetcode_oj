/*
下载插件
LCS 01
2023-09-04 20:19:22
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastMinutes(int n) {
        double sum = 0;
        while (Math.pow(2d, sum) < n) {
            sum++;
        }
        return (int) sum + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
