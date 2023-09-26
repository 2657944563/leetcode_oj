// 开始时间：2023-09-26 12:20:57
// 题目标题：组合
// 题目标记：combinations
// 题目编号：77
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * <p>
 * Related Topics 回溯 👍 1499 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 1, n, k);
        return result;
    }

    void dfs(LinkedList<List<Integer>> result, LinkedList<Integer> target, int l, int n, int k) {
        if (target.size() == k) {
            result.add(new LinkedList<>(target));
            return;
        }
        for (int i = l; i <= n; i++) {
            target.add(i);
            dfs(result, target, i + 1, n, k);
            target.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

