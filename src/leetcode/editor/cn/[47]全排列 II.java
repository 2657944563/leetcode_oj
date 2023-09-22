// 开始时间：2023-09-22 11:27:23
// 题目标题：全排列 II
// 题目标记：permutations-ii
// 题目编号：47
// 题目描述：

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 1460 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        int[] flag = new int[nums.length];
        dfs(result, new LinkedList<>(), nums, flag);
        return result.stream().distinct().collect(Collectors.toList());
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

