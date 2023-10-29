// 开始时间：2023-10-29 14:51:16
// 题目标题：和为零的 N 个不同整数
// 题目标记：find-n-unique-integers-sum-up-to-zero
// 题目编号：1304
// 题目描述：

import java.util.LinkedList;

/**
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：[-1,0,1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：[0]
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
 * Related Topics 数组 数学 👍 79 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sumZero(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        if (n % 2 == 1) {
            list.add(0);
            n -= 1;
        }
        while (n > 0) {
            list.add(n);
            list.add(n * -1);
            n -= 2;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

