// 开始时间：2023-10-19 10:59:31
// 题目标题：高度检查器
// 题目标记：height-checker
// 题目编号：1051
// 题目描述：

import java.util.Arrays;

/**
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 * <p>
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 * <p>
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 * <p>
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * 解释：
 * 高度：[5,1,2,3,4]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都不匹配。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 * 解释：
 * 高度：[1,2,3,4,5]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都匹配。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 计数排序 排序 👍 163 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int heightChecker(int[] heights) {
        int sum = 0;
        int[] sort = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sort);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sort[i]) {
                sum++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

