// 开始时间：2023-09-25 16:24:21
// 题目标题：插入区间
// 题目标记：insert-interval
// 题目编号：57
// 题目描述：

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 👍 822 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int begin1 = newInterval[0], end1 = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        boolean findInter = true;
        boolean important = false;

        for (int[] cur : intervals) {
            if (begin1 <= cur[1] && end1 >= cur[0]) {
                begin1 = Math.min(begin1, cur[0]);
                end1 = Math.max(end1, cur[1]);
                continue;
            }

            //如果newInterval 此时需要插入，记录一下
            if (end1 < cur[0] && findInter) {
                ans.add(new int[]{begin1, end1});
                findInter = false;
                important = true;
            }

            ans.add(new int[]{cur[0], cur[1]});
        }

        if (!important) {
            ans.add(new int[]{begin1, end1});
        }

        return ans.stream().toArray(int[][]::new);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

