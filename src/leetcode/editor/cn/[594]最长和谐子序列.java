// 开始时间：2023-09-24 09:25:09
// 题目标题：最长和谐子序列
// 题目标记：longest-harmonious-subsequence
// 题目编号：594
// 题目描述：

import java.util.Arrays;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 排序 👍 387 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            while (i < j && nums[j] - nums[i] > 1) i++;
            if (nums[j] - nums[i] == 1) ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

