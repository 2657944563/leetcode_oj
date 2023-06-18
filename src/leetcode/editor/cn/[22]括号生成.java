import java.util.LinkedList;
import java.util.List;

/*
括号生成
22
2023-06-17 13:30:49
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> resList;

    public List<String> generateParenthesis(int n) {
        resList = new LinkedList<>();
        so(n, n, "");
        return resList;
    }

    void so(int n, int m, String str) {
        if (n < 0 || m < 0) {
            return;
        }
        if (n == 0 && m == 0) {
            if (!str.isEmpty()) {
                resList.add(str);
            }
            return;
        }
        // 但左括号没有被弹出的时候
        if (n == m) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('(');
            so(n - 1, m, stringBuilder.toString());
        } else {
            // 当左括号弹出数量小于右括号的时候
            StringBuilder stringBuilderLeft = new StringBuilder(str);
            StringBuilder stringBuilderRight = new StringBuilder(str);
            stringBuilderLeft.append('(');
            stringBuilderRight.append(')');
            so(n - 1, m, stringBuilderLeft.toString());
            so(n, m - 1, stringBuilderRight.toString());
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
