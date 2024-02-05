// 开始时间：2024-02-05 09:23:42
// 题目标题：跳跃游戏 V
// 题目标记：jump-game-v
// 题目编号：1340
// 题目描述：

import javax.print.attribute.standard.JobHoldUntil;
import java.util.HashMap;

/**
 * 给你一个整数数组 arr 和一个整数 d 。每一步你可以从下标 i 跳到：
 * <p>
 * <p>
 * i + x ，其中 i + x < arr.length 且 0 < x <= d 。
 * i - x ，其中 i - x >= 0 且 0 < x <= d 。
 * <p>
 * <p>
 * 除此以外，你从下标 i 跳到下标 j 需要满足：arr[i] > arr[j] 且 arr[i] > arr[k] ，其中下标 k 是所有 i 到 j 之间的
 * 数字（更正式的，min(i, j) < k < max(i, j)）。
 * <p>
 * 你可以选择数组的任意下标开始跳跃。请你返回你 最多 可以访问多少个下标。
 * <p>
 * 请注意，任何时刻你都不能跳到数组的外面。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
 * 输出：4
 * 解释：你可以从下标 10 出发，然后如上图依次经过 10 --> 8 --> 6 --> 7 。
 * 注意，如果你从下标 6 开始，你只能跳到下标 7 处。你不能跳到下标 5 处因为 13 > 9 。你也不能跳到下标 4 处，因为下标 5 在下标 4 和 6 之
 * 间且 13 > 9 。
 * 类似的，你不能从下标 3 处跳到下标 2 或者下标 1 处。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [3,3,3,3,3], d = 3
 * 输出：1
 * 解释：你可以从任意下标处开始且你永远无法跳到任何其他坐标。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [7,6,5,4,3,2,1], d = 1
 * 输出：7
 * 解释：从下标 0 处开始，你可以按照数值从大到小，访问所有的下标。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：arr = [7,1,7,1,7,1], d = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：arr = [66], d = 1
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 10^5
 * 1 <= d <= arr.length
 * <p>
 * <p>
 * Related Topics 数组 动态规划 排序 👍 112 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxJumps(int[] arr, int d) {
        int max = 0;
        HashMap<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, jump(arr, i, d, dp));
        }
        return max;
    }

    int jump(int[] arr, int index, int d, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(d)) {
            return dp.get(d);
        }
        int l = Math.max(0, index - d);
        int maxValue = arr[l], maxKey = l;
        for (int i = l; i < Math.min(arr.length - 1, index + d); i++) {
            if (i == index) {
                continue;
            }
            if (arr[i] > maxValue) {
                maxKey = i;
                maxValue = arr[i];
            }
        }
        int value;
        if (maxKey == index) {
            //  不能跳
            value = 1;
            dp.put(index, value);
            return value;
        }
        value = 1 + jump(arr, maxKey, d, dp);
        dp.put(index, value);
        return value;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

