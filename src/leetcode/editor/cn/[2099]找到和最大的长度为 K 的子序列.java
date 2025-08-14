// 开始时间：2025-08-10 19:27:19
// 题目标题：找到和最大的长度为 K 的子序列
// 题目标记：find-subsequence-of-length-k-with-the-largest-sum
// 题目编号：2099
// 题目描述：

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * <p>
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * <p>
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,3], k = 2
 * 输出：[3,3]
 * 解释：
 * 子序列有最大和：3 + 3 = 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-1,-2,3,4], k = 3
 * 输出：[-1,3,4]
 * 解释：
 * 子序列有最大和：-1 + 3 + 4 = 6 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,4,3,3], k = 2
 * 输出：[3,4]
 * 解释：
 * 子序列有最大和：3 + 4 = 7 。
 * 另一个可行的子序列为 [4, 3] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * -10⁵ <= nums[i] <= 10⁵
 * 1 <= k <= nums.length
 * <p>
 * <p>
 * Related Topics 数组 哈希表 排序 堆（优先队列） 👍 71 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int c = nums.length - k;
        Integer[] integers = map.keySet().toArray(new Integer[0]);
        Arrays.sort(integers);
        for (Integer integer : integers) {
            Integer integer1 = map.get(integer);
            if (integer1 >= c) {
                map.put(integer, integer1 - c);
                break;
            } else {
                c -= integer1;
                map.put(integer, 0);
            }
        }
        int[] result = new int[k];
        int p = 0;
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer > 0) {
                map.put(num, integer - 1);
                result[p++] = num;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

