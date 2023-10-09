// 开始时间：2023-10-09 15:09:29
// 题目标题：最小和分割
// 题目标记：split-with-minimum-sum
// 题目编号：2578
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 * <p>
 * <p>
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * <p>
 * <p>
 * <p>
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * <p>
 * <p>
 * num1 和 num2 可以包含前导 0 。
 * <p>
 * <p>
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 * <p>
 * 注意：
 * <p>
 * <p>
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 10 <= num <= 10⁹
 * <p>
 * <p>
 * Related Topics 贪心 数学 排序 👍 48 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitNum(int num) {
        int i = 0, n = num;
        while (n > 0) {
            i++;
            n /= 10;
        }
        int[] result = new int[i];
        i = 0;
        while (num > 0) {
            result[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(result);
        int a = 0, b = 0;
        for (int l = 0; l < result.length; l++) {
            if (l % 2 == 1) {
                a = a * 10 + result[l];
            } else {
                b = b * 10 + result[l];
            }
        }
        return a + b;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

