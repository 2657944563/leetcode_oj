import java.nio.charset.StandardCharsets;

/*
Excel 表列序号
171
2023-09-01 16:52:58
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (byte aByte : columnTitle.getBytes()) {
            sum = sum * 26 + aByte - 'A' + 1;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
