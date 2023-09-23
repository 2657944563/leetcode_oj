// 开始时间：2023-09-23 11:08:53
// 题目标题：组合总和 II
// 题目标记：combination-sum-ii
// 题目编号：40
// 题目描述：

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 1450 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        List<List<Integer>> result = new LinkedList<>();
        back(result, new LinkedList(), 0, target, candidates.length - 1, candidates);
        return result;
    }

    void back(List<List<Integer>> result, LinkedList<Integer> temp,
              int sum, int target, int i, int[] candidates) {
        // 相等就保存
        if (target == sum) {
            result.add(new LinkedList<>(temp));
        }
        // 大于就减枝
        if (target < sum) {
            return;
        }
        //小于就加自己或者下一位数值
        for (int j = i; j >= 0; j--) {
            sum += candidates[j];
            temp.add(candidates[j]);
            back(result, temp, sum, target, j - 1, candidates);
            sum -= candidates[j];
            temp.removeLast();
            while (j != 0 && candidates[j - 1] == candidates[j]) {
                j--;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

