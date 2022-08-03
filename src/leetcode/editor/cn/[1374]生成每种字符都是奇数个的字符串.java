/*
生成每种字符都是奇数个的字符串
1374
2022-08-01 09:38:45
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String generateTheString(int n) {
        StringBuilder str = new StringBuilder();
        if ((n & 1) == 1) {
            for (int i = 0; i < n; i++) {
                str.append('a');
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                str.append('a');
            }
            str.append('b');
        }
        return str.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
