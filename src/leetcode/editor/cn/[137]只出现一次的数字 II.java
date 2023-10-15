// 开始时间：2023-10-15 12:19:45
// 题目标题：只出现一次的数字 II
// 题目标记：single-number-ii
// 题目编号：137
// 题目描述：

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * <p>
 * Related Topics 位运算 数组 👍 1109 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.merge(num, 1, Integer::sum);
        }
        return hm.entrySet().stream().filter(o -> o.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList()).get(0);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

