// 开始时间：2024-02-05 15:03:31
// 题目标题：按照频率将数组升序排序
// 题目标记：sort-array-by-increasing-frequency
// 题目编号：1636
// 题目描述：

import java.util.*;

/**
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 哈希表 排序 👍 167 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.merge(num, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        hm.entrySet().stream().sorted(
                (o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o2.getKey() - o1.getKey();
                    }
                    return o1.getValue() - o2.getValue();
                }
        ).forEach(o -> {
            for (int integer = 0; integer < o.getValue(); integer++) {
                list.add(o.getKey());
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

