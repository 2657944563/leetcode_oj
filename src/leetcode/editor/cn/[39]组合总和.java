// 开始时间：2023-09-23 10:38:09
// 题目标题：组合总和
// 题目标记：combination-sum
// 题目编号：39
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所
 * 有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 2625 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            back(result, temp, sum, target, j, candidates);
            sum -= candidates[j];
            temp.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

