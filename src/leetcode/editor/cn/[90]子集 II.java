// 开始时间：2023-09-22 16:29:25
// 题目标题：子集 II
// 题目标记：subsets-ii
// 题目编号：90
// 题目描述：

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * <p>
 * Related Topics 位运算 数组 回溯 👍 1153 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        back(nums, result, new LinkedList<>(), 0);
        return result.stream().distinct().collect(Collectors.toList());
    }

    void back(int[] nums, List<List<Integer>> result, LinkedList<Integer> re, int i) {
        result.add(new LinkedList<>(re));
        for (int j = i; j < nums.length; j++) {
            re.add(nums[j]);
            back(nums, result, re, j + 1);
            re.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

