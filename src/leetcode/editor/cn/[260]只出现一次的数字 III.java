// 开始时间：2023-10-16 11:36:35
// 题目标题：只出现一次的数字 III
// 题目标记：single-number-iii
// 题目编号：260
// 题目描述：

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 3 * 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 * <p>
 * <p>
 * Related Topics 位运算 数组 👍 782 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.merge(num, 1, Integer::sum);
        }
        return hm.entrySet().stream().filter(o -> o.getValue() == 1).mapToInt(Map.Entry::getKey).toArray();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

