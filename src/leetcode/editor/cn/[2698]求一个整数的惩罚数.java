// 开始时间：2023-10-25 11:45:46
// 题目标题：求一个整数的惩罚数
// 题目标记：find-the-punishment-number-of-an-integer
// 题目编号：2698
// 题目描述：

/**
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * <p>
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * <p>
 * <p>
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 10
 * 输出：182
 * 解释：总共有 3 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * 因此，10 的惩罚数为 1 + 81 + 100 = 182
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 37
 * 输出：1478
 * 解释：总共有 4 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
 * 因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 1000
 * <p>
 * <p>
 * Related Topics 数学 回溯 👍 71 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) ans += i * i;
        }
        return ans;
    }

    boolean check(int t, int x) {
        if (t == x) return true;
        int d = 10;
        while (t >= d && t % d <= x) {
            if (check(t / d, x - (t % d))) return true;
            d *= 10;
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

