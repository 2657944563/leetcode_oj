// 开始时间：2025-08-22 20:48:47
// 题目标题：千位分隔数
// 题目标记：thousand-separator
// 题目编号：1556
// 题目描述：

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 987
 * 输出："987"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1234
 * 输出："1.234"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 123456789
 * 输出："123.456.789"
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 0
 * 输出："0"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n < 2^31
 * <p>
 * <p>
 * Related Topics 字符串 👍 32 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String thousandSeparator(int n) {
//        "1234"
        StringBuilder sb = new StringBuilder(n + "");
        for (int i = sb.length() - 1; i > 0; i--) {
            if ((i - (n + "").length()) % 3 == 0) {
                sb.insert(i, ".");
            }
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

