// 开始时间：2023-10-14 20:11:48
// 题目标题：十进制整数的反码
// 题目标记：complement-of-base-10-integer
// 题目编号：1009
// 题目描述：

/**
 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何
 * 二进制表示中都不含前导零。
 * <p>
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 * <p>
 * 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：5
 * 输出：2
 * 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：7
 * 输出：0
 * 解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：10
 * 输出：5
 * 解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= N < 10^9
 * 本题与 476：https://leetcode-cn.com/problems/number-complement/ 相同
 * <p>
 * <p>
 * Related Topics 位运算 👍 97 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int i = n, l = 0;
        while (n > 0) {
            n >>= 1;
            l = l * 2 + 1;
        }
        return i ^ l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

