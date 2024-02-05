// 开始时间：2024-02-05 16:24:44
// 题目标题：获取生成数组中的最大值
// 题目标记：get-maximum-in-generated-array
// 题目编号：1646
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * <p>
 * <p>
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 100
 * <p>
 * <p>
 * Related Topics 数组 模拟 👍 88 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int max = 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + res[i / 2 + 1];
            }
            max = Math.max(max, res[i]);
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

