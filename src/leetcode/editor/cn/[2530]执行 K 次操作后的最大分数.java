// 开始时间：2023-10-18 12:04:10
// 题目标题：执行 K 次操作后的最大分数
// 题目标记：maximal-score-after-applying-k-operations
// 题目编号：2530
// 题目描述：

import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * <p>
 * <p>
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * <p>
 * <p>
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [10,10,10,10,10], k = 5
 * 输出：50
 * 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,10,3,3,3], k = 3
 * 输出：17
 * 解释：可以执行下述操作：
 * 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
 * 第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
 * 第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
 * 最后分数是 10 + 4 + 3 = 17 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length, k <= 10⁵
 * 1 <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 贪心 数组 堆（优先队列） 👍 47 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxKelements(int[] nums, int k) {
        TreeMap<Integer, Integer> tree = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            tree.merge(num, 1, Integer::sum);
        }
        long sum = 0;
        for (; k > 0; ) {
            Map.Entry<Integer, Integer> entry = tree.pollFirstEntry();
            if (entry == null) {
                return sum;
            }
            if (k <= entry.getValue()) {
                return sum + (long) k * entry.getKey();
            } else {
                k -= entry.getValue();
                sum += (long) entry.getKey() * entry.getValue();
                tree.merge((int) Math.ceil(entry.getKey() / 3.0), entry.getValue(), Integer::sum);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

