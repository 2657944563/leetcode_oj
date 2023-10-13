// 开始时间：2023-10-13 23:04:08
// 题目标题：三角形的最大周长
// 题目标记：largest-perimeter-triangle
// 题目编号：976
// 题目描述：

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,1,2]
 * 输出：5
 * 解释：你可以用三个边长组成一个三角形:1 2 2。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,1,10]
 * 输出：0
 * 解释：
 * 你不能用边长 1,1,2 来组成三角形。
 * 不能用边长 1,1,10 来构成三角形。
 * 不能用边长 1、2 和 10 来构成三角形。
 * 因为我们不能用任何三条边长来构成一个非零面积的三角形，所以我们返回 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= nums.length <= 10⁴
 * 1 <= nums[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 贪心 数组 数学 排序 👍 255 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] >= nums[i - 1] * 2) {
                continue;
            }
            for (int l = i - 1; l >= 1; l--) {
                if (nums[i] < nums[l] + nums[l - 1]) {
                    return nums[i] + nums[l] + nums[l - 1];
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

