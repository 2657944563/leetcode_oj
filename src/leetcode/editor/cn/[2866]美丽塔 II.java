// 开始时间：2023-10-06 14:36:29
// 题目标题：美丽塔 II
// 题目标记：beautiful-towers-ii
// 题目编号：2866
// 题目描述：

import java.util.List;

/**
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 * <p>
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 * <p>
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 * <p>
 * <p>
 * 1 <= heights[i] <= maxHeights[i]
 * heights 是一个 山状 数组。
 * <p>
 * <p>
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山状 数组：
 * <p>
 * <p>
 * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 * <p>
 * <p>
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：maxHeights = [5,3,4,1,1]
 * 输出：13
 * 解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山状数组，峰值在 i = 0 处。
 * 13 是所有美丽塔方案中的最大高度和。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：maxHeights = [6,5,3,9,2,7]
 * 输出：22
 * 解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山状数组，峰值在 i = 3 处。
 * 22 是所有美丽塔方案中的最大高度和。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：maxHeights = [3,2,5,5,2,3]
 * 输出：18
 * 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山状数组，最大值在 i = 2 处。
 * 注意，在这个方案中，i = 3 也是一个峰值。
 * 18 是所有美丽塔方案中的最大高度和。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n == maxHeights <= 10⁵
 * 1 <= maxHeights[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 栈 数组 单调栈 👍 21 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int left = 0, right = 0;
        long[] dpLeft = new long[maxHeights.size()];
        long[] dpRight = new long[maxHeights.size()];
        long max = 0;
        // 递减 递增
        while (right < maxHeights.size()) {
            while (right < maxHeights.size() && maxHeights.get(right) < maxHeights.get(left)) {
                left = right;
                right++;
            }
            while (right < maxHeights.size() && maxHeights.get(right) >= maxHeights.get(left)) {
                left = right;
                right++;
            }
            max = Math.max(max, getHeights(maxHeights, right - 1, dpLeft, dpRight));
        }
        return max;
    }

    long getHeights(List<Integer> maxHeights, int right, long[] dpLeft, long[] dpRight) {
        long sum = 0;
        int rightTemp = right - 1;
        Integer leftOne = maxHeights.get(right);
        while (rightTemp >= 0) {
            Integer leftTow = maxHeights.get(rightTemp);
            if (dpLeft[rightTemp] != 0 && maxHeights.get(rightTemp) <= maxHeights.get(rightTemp + 1)) {
                sum += dpLeft[rightTemp] + leftTow;
                break;
            } else {
                if (leftOne >= leftTow) {
                    leftOne = leftTow;
                }
                sum += leftOne;
                if (leftOne == 0) {
                    break;
                }
            }
            rightTemp--;
        }
        dpLeft[right] = sum;

        rightTemp = right + 1;
        Integer rightOne = maxHeights.get(right);
        while (rightTemp < maxHeights.size()) {
            if (dpRight[rightTemp] != 0 && maxHeights.get(rightTemp) >= maxHeights.get(rightTemp - 1)) {
                sum += dpRight[rightTemp] + rightOne;
            } else {
                Integer rightTow = maxHeights.get(rightTemp);
                if (rightOne >= rightTow) {
                    rightOne = rightTow;
                }
                sum += rightOne;
                rightTemp++;
            }
        }
        dpRight[right] = sum - dpLeft[right];
        return sum + maxHeights.get(right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

