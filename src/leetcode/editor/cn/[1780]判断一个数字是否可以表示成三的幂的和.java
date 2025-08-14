// 开始时间：2025-08-14 18:23:21
// 题目标题：判断一个数字是否可以表示成三的幂的和
// 题目标记：check-if-number-is-a-sum-of-powers-of-three
// 题目编号：1780
// 题目描述：

import java.util.ArrayList;

/**
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * <p>
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3ˣ ，我们称这个整数 y 是三的幂。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 3¹ + 3²
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 3⁰ + 3² + 3⁴
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 21
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁷
 * <p>
 * <p>
 * Related Topics 数学 👍 142 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPowersOfThree(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; ; i++) {
            int s = (int) Math.pow(3, i);
            if (s <= n) {
                dp.add(s);
            } else {
                break;
            }
        }
        for (int i = dp.size() - 1; i >= 0; i--) {
            if (dp.get(i) <= n) {
                n -= dp.get(i);
            }
        }
        return n == 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

