// 开始时间：2023-10-09 15:21:07
// 题目标题：解码方法
// 题目标记：decode-ways
// 题目编号：91
// 题目描述：

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * <p>
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * <p>
 * <p>
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 👍 1453 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i % 3] = 0;
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) f[i % 3] = f[(i - 1) % 3];
            if (10 <= b && b <= 26) f[i % 3] += f[(i - 2) % 3];
        }
        return f[n % 3];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

