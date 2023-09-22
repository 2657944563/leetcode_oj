// 开始时间：2023-09-22 11:35:48
// 题目标题：合并区间
// 题目标记：merge-intervals
// 题目编号：56
// 题目描述：

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回
 * 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 排序 👍 2106 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        List<int[]> collect = Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0])).collect(Collectors.toList());
        int l = collect.get(0)[0], r = collect.get(0)[1];
        for (int[] ints : collect) {
            if (ints[0] <= r) {
                r = Math.max(ints[1], r);
            } else {
                result.add(new int[]{l, r});
                l = ints[0];
                r = ints[1];
            }
        }
        result.add(new int[]{l, r});
        return result.toArray(int[][]::new);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

