// 开始时间：2023-09-22 10:27:12
// 题目标题：全排列
// 题目标记：permutations
// 题目编号：46
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 2703 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        int[] flag = new int[nums.length];
        dfs(result, new LinkedList<>(), nums, flag);
        return result;
    }

    void dfs(LinkedList<List<Integer>> result, LinkedList<Integer> re, int[] nums, int[] flag) {
        if (re.size() == nums.length) {
            result.add(new LinkedList<>(re));
            return;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                re.add(nums[i]);
                dfs(result, re, nums, flag);
                flag[i] = 0;
                re.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

