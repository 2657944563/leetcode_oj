// 开始时间：2023-11-18 12:39:48
// 题目标题：数位和相等数对的最大和
// 题目标记：max-sum-of-a-pair-with-equal-sum-of-digits
// 题目编号：2342
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与
 * nums[j] 的数位和相等。
 * <p>
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 排序 堆（优先队列） 👍 45 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSum(int[] nums) {
        int max = 0;
        int[][] result = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            result[i][1] = nums[i];
            int n = 0, t = nums[i];
            while (t > 0) {
                n += t % 10;
                t /= 10;
            }
            result[i][0] = n;
        }
        Arrays.sort(result, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i][0] == result[i + 1][0]) {
                max = Math.max(result[i][1] + result[i + 1][1], max);
                while (i < result.length - 1 && result[i][0] == result[i + 1][0]) {
                    i++;
                }
            }
        }
        return max == 0 ? -1 : max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

